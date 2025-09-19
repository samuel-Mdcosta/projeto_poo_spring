package dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record OrderCreateDto(@NotEmpty(message = "a lista de itens nao pode estar vazia")
@Valid List<ItemCreateDto> items) {
    
}
