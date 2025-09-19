package service;

import java.util.List;
import model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.OrderRepository;

@Service

public class OrderService {

    private final OrderRepository orderRepository;

    //construtor
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //busca os pedidos
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    //salva um pedido
    public Order saveOrder (Order order){
        return orderRepository.save(order);
    }
}
