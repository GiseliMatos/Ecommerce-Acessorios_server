package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.service.IOrderItemService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("order-items")
public class OrderItemController extends CrudController<OrderItem, OrderItemDTO, Long> {

    private static IOrderItemService orderItemService;
    private static ModelMapper modelMapper;

    public OrderItemController(IOrderItemService orderItemService, ModelMapper modelMapper) {
        super(OrderItem.class, OrderItemDTO.class);
        OrderItemController.orderItemService = orderItemService;
        OrderItemController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<OrderItem, Long> getService() {
        return orderItemService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    // Listar todos os itens de um pedido
    @GetMapping("order/{orderId}")
    public ResponseEntity<List<OrderItem>> findAllByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderItemService.findAllByOrderId(orderId));
    }

    // Listar item específico de um pedido
    @GetMapping("order/{orderId}/product/{productId}")
    public ResponseEntity<List<OrderItem>> findByOrderAndProduct(@PathVariable Long orderId,
                                                                 @PathVariable Long productId) {
        return ResponseEntity.ok(orderItemService.findAllByOrderIdAndProductId(orderId, productId));
    }

    // Deletar item de um pedido
    @DeleteMapping("order/{orderId}/product/{productId}")
    public ResponseEntity<Void> deleteByOrderAndProduct(@PathVariable Long orderId,
                                                        @PathVariable Long productId) {
        orderItemService.removeItem(orderId, productId);
        return ResponseEntity.noContent().build();
    }

    // Adicionar quantidade a um item existente
    @PostMapping("order/{orderId}/product/{productId}/add")
    public ResponseEntity<OrderItem> addQuantity(@PathVariable Long orderId,
                                                 @PathVariable Long productId,
                                                 @RequestParam int quantity) {
        OrderItem updatedItem = orderItemService.addQuantity(orderId, productId, quantity);
        return ResponseEntity.ok(updatedItem);
    }

    @PostMapping("order/{orderId}/product/{productId}/remove")
    public ResponseEntity<OrderItem> removeQuantity(@PathVariable Long orderId,
                                                    @PathVariable Long productId,
                                                    @RequestParam int quantity) {
        OrderItem updatedItem = orderItemService.removeQuantity(orderId, productId, quantity);
        if (updatedItem == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedItem);
    }
}
