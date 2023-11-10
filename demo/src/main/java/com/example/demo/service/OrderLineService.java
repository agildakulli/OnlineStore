package com.example.demo.service;
import com.example.demo.entity.OrderLine;
import com.example.demo.respository.OrderLineRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {
    private final OrderLineRespository orderLineRepository;

    @Autowired
    public OrderLineService(OrderLineRespository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public Optional<OrderLine> getOrderLineById(Long orderLineId) {
        return orderLineRepository.findById(orderLineId);
    }

    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(Long orderLineId) {
        orderLineRepository.deleteById(orderLineId);
    }
    // Add more service methods as needed
}
