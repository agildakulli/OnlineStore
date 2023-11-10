package com.example.demo.respository;

import com.example.demo.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRespository extends JpaRepository<OrderLine,Long> {
}
