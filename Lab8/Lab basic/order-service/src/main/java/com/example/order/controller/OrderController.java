package com.example.order.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orders = Arrays.asList(
        new Order(1,"ORD1",100),
        new Order(2,"ORD2",200)
    );

    @GetMapping
    public List<Order> getAll(){ return orders; }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id){
        return orders.stream().filter(o->o.id==id).findFirst().orElseThrow();
    }

    static class Order{
        public int id; public String orderNumber; public double total;
        public Order(int id,String orderNumber,double total){
            this.id=id; this.orderNumber=orderNumber; this.total=total;
        }
    }
}