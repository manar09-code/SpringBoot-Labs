package com.example.order;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ProductClient productClient;
    private Map<Long, Order> orderMap = new HashMap<>();
    private Long nextId = 1L;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Product product = productClient.getProduct(order.getProductId());
        order.setId(nextId++);
        order.setProduct(product);
        order.setTotalPrice(product.getPrice() * order.getQuantity());
        orderMap.put(order.getId(), order);
        return order;
    }

    @GetMapping
    public List<Order> getAll() {
        return new ArrayList<>(orderMap.values());
    }
}
