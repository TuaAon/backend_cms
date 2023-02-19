package com.main.backend_cms.controller;

import org.springframework.web.bind.annotation.RestController;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/showProducts") //Mockup for testing
    public ResponseEntity<?> getAllProducts(){
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.status(200).body(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }

    @PostMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
                return ResponseEntity.status(200).body(productService.createProduct(product));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("create failed");
        }
    }
    
}
