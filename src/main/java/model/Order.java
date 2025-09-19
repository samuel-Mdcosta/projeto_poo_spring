package model;

import java.time.LocalDateTime;
import java.util.List;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//cria um modelo para o jpa
@Entity
@Table(name = "orders")
//regra nao precisa de ponto e virgula

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Order(){
    }

    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public LocalDateTime getCreatedAt() { 
        return createdAt; 
    } 
 
    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt; 
    } 
    
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    //metodo para calcular o pedido
    public double getTotal(){
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    //meotodo adiciona items
    public void addItem(Item item){
        items.add(item);
        item.setOrder(this);
    }

    //metodo para remover
    public void removeItem(Item item){
        items.remove(item);
        item.setOrder(null);
    }
}
