package com.example.product.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = Arrays.asList(
        new Product(1,"Laptop",1299.99),
        new Product(2,"Phone",699.99)
    );

    @GetMapping
    public List<Product> getAll(){ return products; }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return products.stream().filter(p->p.id==id).findFirst().orElseThrow();
    }

    static class Product{
        public int id; public String name; public double price;
        public Product(int id,String name,double price){
            this.id=id; this.name=name; this.price=price;
        }
    }
}