package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "total_cost")
    private double totalCost;
    @JoinColumn(name = "delivery_address")
    private String deliveryAddress;
    @JoinColumn(name = "date_of_submission")
    private Date dateOfSubmission;
}
