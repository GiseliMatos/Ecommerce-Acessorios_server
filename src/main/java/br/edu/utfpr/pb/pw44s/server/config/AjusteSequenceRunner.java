package br.edu.utfpr.pb.pw44s.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class AjusteSequenceRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        var sequences = jdbcTemplate.queryForList(
                "SELECT c.relname AS table_name, a.attname AS column_name, " +
                        "       pg_get_serial_sequence(c.relname, a.attname) AS sequence_name " +
                        "FROM pg_class c " +
                        "JOIN pg_attribute a ON a.attrelid = c.oid " +
                        "JOIN pg_type t ON a.atttypid = t.oid " +
                        "WHERE c.relkind = 'r' " +  // tabelas
                        "  AND t.typname LIKE 'int%' " +  // inteiros
                        "  AND a.attnum > 0 " +
                        "  AND pg_get_serial_sequence(c.relname, a.attname) IS NOT NULL"
        );

        for (var row : sequences) {
            String table = (String) row.get("table_name");
            String column = (String) row.get("column_name");
            String sequence = (String) row.get("sequence_name");

            String sql = String.format(
                    "SELECT setval('%s', COALESCE((SELECT MAX(%s) FROM %s), 0) + 1, false);",
                    sequence, column, table
            );

            jdbcTemplate.execute(sql);
        }
    }
}
