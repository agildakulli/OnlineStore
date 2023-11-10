package com.example.demo.respository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Order, Long> {
}
