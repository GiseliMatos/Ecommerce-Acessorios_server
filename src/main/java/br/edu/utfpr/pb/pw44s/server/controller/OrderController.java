package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.dto.ProductDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final IOrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(IOrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAllByAuthenticatedUser() {
        List<Order> orders = orderService.findAllByAuthenticatedUser();
        
        List<OrderDTO> dtoList = orders.stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setDateOrder(order.getDateOrder());
            dto.setTotalPrice(order.getTotalPrice());
            dto.setFormaPagamento(order.getFormaPagamento());
            dto.setFormaEntrega(order.getFormaEntrega());
            
            // Mapeia o endereço
            AddressDTO addressDTO = modelMapper.map(order.getAddress(), AddressDTO.class);
            dto.setAddress(addressDTO);
            
            // Mapeia os itens
            List<OrderItemDTO> itemsDTO = order.getItems().stream().map(item -> {
                OrderItemDTO itemDTO = new OrderItemDTO();
                itemDTO.setId(item.getId());
                itemDTO.setPrice(item.getPrice());
                itemDTO.setQuantity(item.getQuantity());
                
                // Mapeia o produto
                ProductDTO productDTO = modelMapper.map(item.getProduct(), ProductDTO.class);
                itemDTO.setProduct(productDTO);
                
                return itemDTO;
            }).collect(Collectors.toList());
            
            dto.setItems(itemsDTO);
            
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);
        
        // Mapeia a resposta
        OrderDTO responseDTO = new OrderDTO();
        responseDTO.setId(order.getId());
        responseDTO.setDateOrder(order.getDateOrder());
        responseDTO.setTotalPrice(order.getTotalPrice());
        responseDTO.setFormaPagamento(order.getFormaPagamento());
        responseDTO.setFormaEntrega(order.getFormaEntrega());
        
        AddressDTO addressDTO = modelMapper.map(order.getAddress(), AddressDTO.class);
        responseDTO.setAddress(addressDTO);
        
        List<OrderItemDTO> itemsDTO = order.getItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setQuantity(item.getQuantity());
            
            ProductDTO productDTO = modelMapper.map(item.getProduct(), ProductDTO.class);
            itemDTO.setProduct(productDTO);
            
            return itemDTO;
        }).collect(Collectors.toList());
        
        responseDTO.setItems(itemsDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
