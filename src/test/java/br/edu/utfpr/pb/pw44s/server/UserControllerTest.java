package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;


    @BeforeEach
    public void cleanup() {
        orderItemRepository.deleteAll();
        orderRepository.deleteAll();
        addressRepository.deleteAll();
        userRepository.deleteAll();
    }

    // methodName_condition_expectedBehaviour
    @Test
    public void postUser_quandoUsuarioValido_retornaOK() {
        User user = createValidUser();

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_quandoUsuarioValido_usuarioSalvoNoBanco() {
        User user = createValidUser();

        testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    public void postUser_quandoUsuarioValido_senhaCriptografadaNoBanco() {
        User user = createValidUser();

        testRestTemplate.postForEntity("/users", user, Object.class);

        List<User> users = userRepository.findAll();
        User userDB = users.get(0);

        assertThat(user.getPassword()).isNotEqualTo(userDB.getPassword());
    }

    @Test
    public void postUser_quandoUsuarioComUsernameNulo_retornaBadRequest() {
        User user = createValidUser();
        user.setUsername(null);

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_quandoUsuarioComUsernameCurto_retornaBadRequest() {
        User user = createValidUser();
        user.setUsername("abc"); // menos de 4 chars

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_quandoSenhaNaoSeguePadrao_retornaBadRequest() {
        User user = createValidUser();
        user.setPassword("password"); // só minúsculas, sem número e maiúscula

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private User createValidUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        return user;
    }
}
