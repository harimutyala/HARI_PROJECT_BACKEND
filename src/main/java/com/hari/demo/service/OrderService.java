package com.hari.demo.service;

import com.hari.demo.model.Order;
import com.hari.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String username) {
        return orderRepository.findByUserUsername(username);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
