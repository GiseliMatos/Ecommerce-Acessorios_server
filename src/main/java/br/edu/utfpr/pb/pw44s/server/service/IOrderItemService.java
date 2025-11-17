package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderItemService extends ICrudService<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long orderId);

    List<OrderItem> findAllByOrderIdAndProductId(Long orderId, Long productId);

    OrderItem createNewItem(Long orderId, Long productId, int quantity, BigDecimal price);

    OrderItem addQuantity(Long orderId, Long productId, int quantity);

    OrderItem removeQuantity(Long orderId, Long productId, int quantity);

    void removeItem(Long orderId, Long productId);
}
