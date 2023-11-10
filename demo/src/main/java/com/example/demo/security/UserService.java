package com.example.demo.security;

import com.example.demo.entity.Category;
import com.example.demo.respository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final CategoryRespository categoryRespository;
    @Autowired
    public UserService(CategoryRespository categoryRespository){
        this.categoryRespository=categoryRespository;
    }
    public List<Category> getAllCategories(){
        return categoryRespository.findAll();
    }
    
}
