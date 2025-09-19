package model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import service.OrderService;

@Component

public class TesteInjecao implements CommandLineRunner {

    private final OrderService orderService;

    public TesteInjecao(OrderService orderService){
        this.orderService = orderService;
    }
    @Override
    public void run(String... args) throws Exception{
        System.out.println("teste iniciado");
        
        //cria o pedido
        Order pedido = new Order();
        Item item = new Item("cesta basica", 2, 175.00);
        pedido.addItem(item);

        //salvar pedido
        Order salvar = orderService.saveOrder(pedido);

        System.out.println("Pedido salvo com ID: " + salvar.getId());
        
        //buscar pedidos
        System.out.println("pedidos cadastrados:");
        orderService.getAllOrders().forEach(p -> System.out.println("id:" + p.getId()));
    }
}
