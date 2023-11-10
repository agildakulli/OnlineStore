package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String address;

    public User() {
    }
    @ManyToMany
    @JoinTable(name="user_product",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public void setId(Long userId) {
    }
}
