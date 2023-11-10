package com.example.demo.security;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.respository.CategoryRespository;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRespository userRespository;
    @Autowired
    public UserService(UserRespository userRespository){
        this.userRespository=userRespository;
    }
    public List<User> getAllUser(){
        return userRespository.findAll();
    }
    public Optional<User> getUserById(Long userId){
        return userRespository.findById(userId);
    }
    public User saveUser(User user){
        return userRespository.save(user);
    }
    public void deleteUser(Long userId){
        userRespository.deleteById(userId);
    }
}
