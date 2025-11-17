package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.CategoryRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager em;

    private Category category;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        // Limpeza
        jdbcTemplate.execute("DELETE FROM tb_product");
        jdbcTemplate.execute("DELETE FROM tb_category");
        jdbcTemplate.execute("ALTER TABLE tb_category ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE tb_product ALTER COLUMN id RESTART WITH 1");

        // Cria categoria e produto
        category = new Category();
        category.setName("Notebook");
        categoryRepository.save(category);

        Product product = new Product();
        product.setName("Notebook Gamer");
        product.setDescription("Notebook para jogos");
        product.setPrice(new BigDecimal("5500.00"));
        product.setUrlImg("url_da_imagem");
        product.setCategory(category);
        productRepository.save(product);
    }

    // usuário logado
    @Test
    public void getProducts_quandoLogado_podeAcessarProdutos() {
        TestRestTemplate authRestTemplate = testRestTemplate.withBasicAuth("usuario", "senha");

        ResponseEntity<Product[]> response = authRestTemplate.getForEntity("/products", Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody()).extracting("name").containsExactly("Notebook Gamer");
    }

    //usuário não logado
    @Test
    public void getProducts_quandoNaoLogado_podeAcessarProdutos() {
        ResponseEntity<Product[]> response = testRestTemplate.getForEntity("/products", Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody()).extracting("name").containsExactly("Notebook Gamer");
    }

}
