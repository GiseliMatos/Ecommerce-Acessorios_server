package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.*;
import br.edu.utfpr.pb.pw44s.server.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    private User user;
    private Order order;
    private Category category;
    private Product product;
    private OrderItem orderItem;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Limpeza
        orderItemRepository.deleteAll();
        orderRepository.deleteAll();
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        userRepository.deleteAll();

        // User
        user = new User();
        user.setUsername("usuario");
        user.setDisplayName("Usuário Teste");
        user.setPassword("{noop}Senha123"); // noop apenas para teste
        user = userRepository.save(user);

        // Order
        order = new Order();
        order.setUser(user);
        order.setDateOrder(LocalDateTime.now());
        order.setTotalPrice(BigDecimal.valueOf(100));
        order = orderRepository.save(order);

        // Category
        category = new Category();
        category.setName("Eletrônicos");
        category = categoryRepository.save(category);

        // Product
        product = new Product();
        product.setName("Notebook Gamer");
        product.setDescription("Notebook potente para jogos");
        product.setPrice(BigDecimal.valueOf(5000));
        product.setUrlImg("http://img.com/notebook.jpg");
        product.setCategory(category);
        product = productRepository.save(product);

        // OrderItem
        orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice());
        orderItem.setQuantity(1);
        orderItem = orderItemRepository.save(orderItem);
    }

    @Test
    @WithMockUser(username = "usuario", password = "Senha123")
    void deletarItemDoPedido_deveRetornarSemConteudo() throws Exception {
        mockMvc.perform(delete("/order-items/order/" + order.getId() + "/product/" + product.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "usuario", password = "Senha123")
    void adicionarQuantidade_deveAumentarQuantidade() throws Exception {
        mockMvc.perform(post("/order-items/order/" + order.getId() + "/product/" + product.getId() + "/add")
                        .param("quantity", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(3)); // 1 + 2
    }

    @Test
    @WithMockUser(username = "usuario", password = "Senha123")
    void removerQuantidade_reducaoParcial_deveAtualizarQuantidade() throws Exception {
        orderItem.setQuantity(5);
        orderItemRepository.save(orderItem);

        mockMvc.perform(post("/order-items/order/" + order.getId() + "/product/" + product.getId() + "/remove")
                        .param("quantity", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(3)); // 5 - 2
    }

    @Test
    @WithMockUser(username = "usuario", password = "Senha123")
    void removerQuantidade_acimaDoTotal_deveRetornarSemConteudo() throws Exception {
        // Tentando remover mais do que a quantidade atual (1)
        mockMvc.perform(post("/order-items/order/" + order.getId() + "/product/" + product.getId() + "/remove")
                        .param("quantity", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
