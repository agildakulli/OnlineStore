package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 255 characters")
    @Column(name = "NAME")
    private String name;
    @NotBlank(message = "Price cannot be blank")
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<User>users;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}






