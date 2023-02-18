package com.main.backend_cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.main.backend_cms.model.Products;
import com.main.backend_cms.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/showProduct") //Mockup for testing
    public ResponseEntity<?> getAllProduct(){
        try {
            return ResponseEntity.status(200).body(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }

    @GetMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Products products) {
        try {
            return ResponseEntity.status(200).body("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }
    
}
