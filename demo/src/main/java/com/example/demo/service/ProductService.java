package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.respository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRespository productRespository;
    @Autowired
    public ProductService(ProductRespository productRespository){
        this.productRespository=productRespository;
    }
    public List<Product> getAllProducts(){
        return productRespository.findAll();
    }
    public Optional<Product> getProductById (Long productId){
        return productRespository.findById(productId);
    }
    public Product saveProduct(Product product){
        return productRespository.save(product);
    }
    public void deleteProduct(Long productId){
        productRespository.deleteById(productId);
    }
}
