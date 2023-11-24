package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 255 characters")
    @Column(name = "NAME")
    private String name;
    @NotBlank(message = "Price cannot be blank")
    private double price;

    private Long categoryId;

    private String categoryName;
}
