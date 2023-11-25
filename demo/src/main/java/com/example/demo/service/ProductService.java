package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.respository.ProductRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRespository productRepository;
    private final ProductMapper productMapper;

//    public List<ProductDto> getAllProducts() {
//        List<Product> products = productRepository.findAll();
//        return products;
//    }

    public List<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(productMapper.mapToDto(product));
        }
        return productDtoList;
    }

    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
    }
    public ProductDto findById(Long productId) {

       Product existingProduct = productRepository.findById(productId).orElseThrow(()->
                new RuntimeException("Product with id: "+productId+" was not found in the database."));
        return productMapper.mapToDto(existingProduct);
    }


    public ProductDto updateProduct(Long productId, ProductDto updatedProductDto) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            productMapper.updateProductFromDto(updatedProductDto, existingProduct);
            Product savedProduct = productRepository.save(existingProduct);
            return productMapper.mapToDto(savedProduct);
        }

        return null;
    }

    public void delete(Long productId) {
        Optional<Product> existingProduct= productRepository.findById(productId);

        if (existingProduct.isPresent()){
            productRepository.delete(existingProduct.get());
        }else {throw new RuntimeException("Product not found with ID: " + productId);}
    }

}
