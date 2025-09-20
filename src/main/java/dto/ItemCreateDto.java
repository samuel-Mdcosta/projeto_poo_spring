package dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ItemCreateDto(@NotBlank(message = "Nome do item nao pode estar vazio") String name, 
                            @Min(value = 1, message = "a quantidade deve ser no minimo 1") int quantity, 
                            @Min(value = 0, message = "o preco nao pode ser negativo") double price) 
{
    //
}
