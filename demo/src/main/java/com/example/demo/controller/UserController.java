package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto) {
        return new  ResponseEntity<UserDto> (userService.save(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateById(@Valid @RequestBody User user, @PathVariable("id") long id) {
        return ResponseEntity.ok(userService.updateUserById(user, id));
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById/{userId}")
    public User findByUserId(@PathVariable("userId") long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "User with id: "+id+" was successfully deleted!";
    }
}



