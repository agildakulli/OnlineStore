package com.example.demo.security;

import com.example.demo.entity.Category;
import com.example.demo.respository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRespository categoryRespository;
    @Autowired
    public CategoryService(CategoryRespository categoryRespository){
        this.categoryRespository=categoryRespository;
    }
    public List<Category> getAllCategories(){
        return categoryRespository.findAll();
    }
    public Optional<Category>getCategoryById(Long categoryId){
        return categoryRespository.findById(categoryId);
    }
    public Category saveCategory ( Category category){
        return categoryRespository.save(category);
    }
    public void deleteCategory(Long categoryId){
        categoryRespository.deleteById(categoryId);
    }
}
