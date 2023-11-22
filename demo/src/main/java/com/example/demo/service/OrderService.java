package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.respository.OrderRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
    private  OrderRespository orderRepository;

    public Order save(Order order){
        order.setProducts(order.getProducts());
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Order updateOrderById(Order order, Long orderId) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);

        if (existingOrder.isPresent()) {
            // Update order properties as needed
            existingOrder.get().setTotalCost(order.getTotalCost());
            existingOrder.get().setDeliveryAddress(order.getDeliveryAddress());
            existingOrder.get().setDateOfSubmission(order.getDateOfSubmission());
            existingOrder.get().setStatus(order.getStatus());

            // You might want to update the relationship with User and OrderLines here

            orderRepository.save(existingOrder.get());
        } else {
            throw new RuntimeException("Order with id: " + orderId + " was not found");
        }

        return existingOrder.get();
    }

    public void deleteOrderById(Long orderId) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        existingOrder.ifPresent(orderRepository::delete);
    }



}
