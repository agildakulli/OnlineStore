package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductMapper {

    public Product mapToEntity(ProductDto productDto){
         Product product=new Product();
         product.setId(productDto.getId());
         product.setName(productDto.getName());
         productDto.setPrice(productDto.getPrice());

         return product;
    }
    public ProductDto mapToDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

}
