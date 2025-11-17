package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderService extends ICrudService<Order, Long> {

    List<Order> findAllByUserId(Long userId);

    BigDecimal calculateTotalByUserId(Long userId);
    
    Order createOrder(OrderDTO orderDTO);
    
    List<Order> findAllByAuthenticatedUser();
}
