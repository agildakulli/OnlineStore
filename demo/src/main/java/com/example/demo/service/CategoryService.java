package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.respository.CategoryRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryRespository categoryRespository;

    public CategoryDto save(CategoryDto categoryDto){
        Category savedCategory = categoryRespository.save(categoryMapper.mapToEntity(categoryDto));

        return categoryMapper.mapToDto(savedCategory);
    }

    public List<CategoryDto> findAll(){
        List<Category> allCategory = categoryRespository.findAll();

        return allCategory.stream().map(category -> categoryMapper.mapToDto(category))
                .collect(Collectors.toList());
    }

    public CategoryDto findById(long categoryId){
        Category existingCategory = categoryRespository.findById(categoryId).orElseThrow(() ->
                new RuntimeException("Category with id: " + categoryId + " not found"));

        return categoryMapper.mapToDto(existingCategory);
    }

    public CategoryDto update(CategoryDto categoryDto, long categoryId) {
        Category category = categoryMapper.mapToEntity(categoryDto);
        category.setId(categoryId);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        Category savedCategory = categoryRespository.save(category);

        return categoryMapper.mapToDto(category);
    }

    public void delete(long categoryId){
        Category category = new Category();
        category.setId(categoryId);
        categoryRespository.delete(category);
    }
}