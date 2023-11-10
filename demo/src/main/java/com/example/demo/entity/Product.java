package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<User>users;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}






