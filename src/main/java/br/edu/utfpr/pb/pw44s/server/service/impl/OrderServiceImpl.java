package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final AuthService authService;

    public OrderServiceImpl(OrderRepository orderRepository,
                           ProductRepository productRepository,
                           AddressRepository addressRepository,
                           AuthService authService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public List<Order> findAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public BigDecimal calculateTotalByUserId(Long userId) {
        return orderRepository.calculateTotalByUserId(userId);
    }

    @Override
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        // Busca o usuário autenticado
        User user = authService.getAuthenticatedUser();
        
        // Busca ou valida o endereço
        Address address;
        if (orderDTO.getAddress().getId() != null) {
            address = addressRepository.findById(orderDTO.getAddress().getId())
                    .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
            
            // Valida se o endereço pertence ao usuário autenticado
            if (address.getUser().getId() != user.getId()) {
                throw new RuntimeException("Endereço não pertence ao usuário autenticado");
            }
        } else {
            throw new RuntimeException("ID do endereço é obrigatório");
        }
        
        // Cria o pedido
        Order order = Order.builder()
                .user(user)
                .address(address)
                .dateOrder(LocalDateTime.now())
                .formaPagamento(orderDTO.getFormaPagamento())
                .formaEntrega(orderDTO.getFormaEntrega())
                .items(new ArrayList<>())
                .build();
        
        // Processa os itens do pedido
        BigDecimal totalPrice = BigDecimal.ZERO;
        
        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            // Busca o produto no banco
            Product product = productRepository.findById(itemDTO.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.getProduct().getId()));
            
            // Cria o item do pedido usando o preço do banco
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .price(product.getPrice())
                    .quantity(itemDTO.getQuantity())
                    .build();
            
            order.getItems().add(orderItem);
            
            // Calcula o total
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity()));
            totalPrice = totalPrice.add(itemTotal);
        }
        
        order.setTotalPrice(totalPrice);
        
        // Salva o pedido (cascade salvará os itens automaticamente)
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllByAuthenticatedUser() {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findAllByUserId(user.getId());
    }

}
