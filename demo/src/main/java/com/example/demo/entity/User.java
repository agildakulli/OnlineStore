package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    private Long Id;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email format")
    @Column(name = "EMAIL")
    private String email;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 5, max = 20, message = "Username length must be between 5 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "Username can only contain letters, numbers, underscores, periods, or dashes")
    @Column(name = "USER_NAME")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern.List({@Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit")})
    @Column(name = "PASSWORD")
    private String password;
    private String role;
    private String address;

    @ManyToMany
    @JoinTable(name="user_product",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}
