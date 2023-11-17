package com.example.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLineDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
