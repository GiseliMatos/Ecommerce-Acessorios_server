package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderItemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemServiceImpl extends CrudServiceImpl<OrderItem, Long> implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, 
                                OrderRepository orderRepository,
                                ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<OrderItem, Long> getRepository() {
        return orderItemRepository;
    }

    @Override
    public List<OrderItem> findAllByOrderId(Long orderId) {
        return orderItemRepository.findAllByOrder_Id(orderId);
    }

    @Override
    public List<OrderItem> findAllByOrderIdAndProductId(Long orderId, Long productId) {
        return orderItemRepository.findAllByOrder_IdAndProduct_Id(orderId, productId);
    }

    @Override
    public OrderItem createNewItem(Long orderId, Long productId, int quantity, BigDecimal price) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        OrderItem item = OrderItem.builder()
                .order(order)
                .product(product)
                .quantity(quantity)
                .price(price)
                .build();
        return orderItemRepository.save(item);
    }

    @Override
    public OrderItem addQuantity(Long orderId, Long productId, int quantity) {
        List<OrderItem> items = orderItemRepository.findAllByOrder_IdAndProduct_Id(orderId, productId);
        if (items.isEmpty()) {
            throw new RuntimeException("Item não encontrado para adicionar quantidade");
        }
        OrderItem item = items.get(0);
        item.setQuantity(item.getQuantity() + quantity);
        return orderItemRepository.save(item);
    }

    @Override
    public OrderItem removeQuantity(Long orderId, Long productId, int quantity) {
        List<OrderItem> items = orderItemRepository.findAllByOrder_IdAndProduct_Id(orderId, productId);
        if (items.isEmpty()) {
            return null;
        }
        OrderItem item = items.get(0);

        int newQuantity = item.getQuantity() - quantity;
        if (newQuantity > 0) {
            item.setQuantity(newQuantity);
            return orderItemRepository.save(item);
        } else {
            orderItemRepository.delete(item);
            return null;
        }
    }

    @Override
    public void removeItem(Long orderId, Long productId) {
        List<OrderItem> items = orderItemRepository.findAllByOrder_IdAndProduct_Id(orderId, productId);
        if (items.isEmpty()) {
            throw new RuntimeException("Item não encontrado para o pedido e produto informados");
        }
        items.forEach(orderItemRepository::delete);
    }
}
