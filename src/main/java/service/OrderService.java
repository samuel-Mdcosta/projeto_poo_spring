package service; 
 
import org.springframework.stereotype.Service;

import dto.OrderDto;
import dto.ItemDto;
import dto.OrderCreateDto;
import repository.ItemRepository;
import repository.OrderRepository;

// Add the necessary imports for missing types
import model.Order;
import model.Item;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public OrderDto createOrder(OrderCreateDto dto) {
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());

        List<Item> items = dto.items().stream()
                .map(i -> new Item(i.name(), i.quantity(), i.price()))
                .collect(Collectors.toList());

        order.setItems(items);

        Order savedOrder = orderRepository.save(order);
        itemRepository.saveAll(items);

        List<ItemDto> itemDTOs = savedOrder.getItems().stream()
                .map(i -> new ItemDto(i.getId(), i.getName(), i.getQuantity(), i.getPrice()))
                .collect(Collectors.toList());

        double total = itemDTOs.stream().mapToDouble(i -> i.price() * i.quantity()).sum();

        return new OrderDto(savedOrder.getId(), savedOrder.getCreatedAt(), itemDTOs, total);
    }

    public List<OrderDto> getAllOrders() {
    return orderRepository.findAll().stream().map(order -> {
        List<ItemDto> itemDtos = order.getItems().stream()
            .map(i -> new ItemDto(i.getId(), i.getName(), i.getQuantity(), i.getPrice()))
            .collect(Collectors.toList());
        double total = itemDtos.stream().mapToDouble(i -> i.price() * i.quantity()).sum();
        return new OrderDto(order.getId(), order.getCreatedAt(), itemDtos, total);
    }).collect(Collectors.toList());
    }

}