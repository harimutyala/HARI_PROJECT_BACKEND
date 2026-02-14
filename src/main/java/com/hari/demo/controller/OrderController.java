package com.hari.demo.controller;

import com.hari.demo.model.Order;
import com.hari.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @jakarta.annotation.PostConstruct
    public void init() {
        System.out.println("✅✅✅ OrderController HAS BEEN INITIALIZED ✅✅✅");
    }

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        // Ensure items are linked
        if (order.getItems() != null) {
            order.getItems().forEach(item -> item.setOrder(order));
        }
        return orderService.createOrder(order);
    }

    @GetMapping("/user/{username}")
    public List<Order> getUserOrders(@PathVariable String username) {
        return orderService.getOrdersByUser(username);
    }
}
