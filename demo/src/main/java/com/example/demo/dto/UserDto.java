package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2,max = 50,message = "First name must be between 2 and 50 characters.")
    private String firstName;

    @NotEmpty
    @Size(min = 2,max = 50,message = "Last name must be between 2 and 50 characters.")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Email
    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String password;

    private Set<RoleDto> roleDtoSet;
}
