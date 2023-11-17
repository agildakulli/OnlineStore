package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.*;

import java.util.Date;

public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private double totalCost;
    private String deliveryAddress;
    private Date dateOfSubmission;
}
