package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.OrderCreateDto;
import dto.OrderDto;
import jakarta.validation.Valid;
import service.OrderService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //quando requisicoes post forem feitas os metos do controller serao iniciados automaaticamente
    @PostMapping
    public ResponseEntity<OrderDto> createOrder (@RequestBody @Valid OrderCreateDto dto){
        OrderDto createdOrder = orderService.createOrder(dto);
        return ResponseEntity.ok(createdOrder);
    }

    //mapea as requisicoes http do tipo get do controller e recuoerar dados
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
    
}