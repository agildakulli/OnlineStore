package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 255 characters")
    @Column(name = "NAME")
    private String name;
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}