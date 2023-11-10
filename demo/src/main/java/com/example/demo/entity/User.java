package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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
}
