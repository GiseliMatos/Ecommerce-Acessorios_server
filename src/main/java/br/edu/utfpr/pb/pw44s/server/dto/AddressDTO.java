package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private Long id;
    
    @NotNull(message = "A rua é obrigatória")
    @Size(min = 2, max = 100, message = "A rua deve ter entre 2 e 100 caracteres")
    private String street;
    
    @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres")
    private String complement;
    
    @NotNull(message = "O CEP é obrigatório")
    @Size(min = 5, max = 10, message = "O CEP deve ter entre 5 e 10 caracteres")
    private String zipCode;
    
    @NotNull(message = "A cidade é obrigatória")
    @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres")
    private String city;
    
    @NotNull(message = "O estado é obrigatório")
    @Size(min = 2, max = 50, message = "O estado deve ter entre 2 e 50 caracteres")
    private String state;
    
    @NotNull(message = "O país é obrigatório")
    @Size(min = 2, max = 50, message = "O país deve ter entre 2 e 50 caracteres")
    private String country;
}
