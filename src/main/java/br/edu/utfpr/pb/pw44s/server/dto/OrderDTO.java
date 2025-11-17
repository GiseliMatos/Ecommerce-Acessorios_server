package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.enums.FormaEntrega;
import br.edu.utfpr.pb.pw44s.server.enums.FormaPagamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private LocalDateTime dateOrder;
    private BigDecimal totalPrice;
    
    @NotNull(message = "A forma de pagamento é obrigatória")
    private FormaPagamento formaPagamento;
    
    @NotNull(message = "A forma de entrega é obrigatória")
    private FormaEntrega formaEntrega;
    
    @NotEmpty(message = "O pedido deve conter pelo menos um item")
    @Valid
    private List<OrderItemDTO> items;
    
    @NotNull(message = "O endereço de entrega é obrigatório")
    @Valid
    private AddressDTO address;
}
