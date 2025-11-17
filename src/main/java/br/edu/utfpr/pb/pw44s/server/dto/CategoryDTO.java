package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotNull
    private String name;
    private Long id;

    public Category convertToEntity(){
        return new Category(this.id, this.name);
    }
}
