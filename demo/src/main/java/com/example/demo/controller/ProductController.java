package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private  ProductService productService;

@PostMapping("/save")
public ProductDto save(@Valid @RequestBody ProductDto productDto) {
    return productService.save(productDto);
}

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ProductDto findById(@PathVariable(name = "productId") Long productId){
    return productService.findById(productId);
//    ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
//        return productService.getProductById(productId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
    }
//    @GetMapping("/view/{studentId}")
//    public StudentDto findById(@PathVariable(name = "studentId") Long studentId) {
//        return studentService.findById(studentId);
//    }


    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId,
                                                    @RequestBody ProductDto updatedProductDto) {
        ProductDto updatedProduct = productService.updateProduct(productId, updatedProductDto);

        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public String delete(@PathVariable(name = "productId") Long productId) {
        productService.delete(productId);
        return "Product successfully deleted!";
    }

}
