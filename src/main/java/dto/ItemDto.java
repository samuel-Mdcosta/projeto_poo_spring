package dto;

public record ItemDto (
    Long id,
    String name,
    int quantity,
    double price) {
    
}
