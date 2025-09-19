package dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
    Long id,
    LocalDateTime createdAt,
    List<ItemDto> items,
    double totalPrice
) {
    
}
