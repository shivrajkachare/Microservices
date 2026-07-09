package com.OrderService.OrderService;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int userid;

    @Column(unique = true, nullable = false)
    private String username;
    private String productName;
    private Integer quantity;
    private double price;

    public  Order(){}
    public Order(int userid,String productName, Integer quantity, double price){
        this.userid = userid;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
