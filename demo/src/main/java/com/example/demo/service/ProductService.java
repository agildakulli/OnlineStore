package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.respository.ProductRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRespository productRepository;
    private final ProductMapper productMapper;

//    public List<ProductDto> getAllProducts() {
//        List<Product> products = productRepository.findAll();
//        return products;
//    }

    public Optional<ProductDto> getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map((Function<? super Product, ? extends ProductDto>) updatedProductDto -> productMapper.mapToDto(updatedProductDto));
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
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

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductDto> getAllProducts() {
        return  getAllProducts();
    }
}
