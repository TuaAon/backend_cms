package com.main.backend_cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.service.ProductService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping(value = "/showProduct") //Mockup for testing
    public ResponseEntity<?> getAllProduct(){
        try {
            return ResponseEntity.status(200).body(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }

    @GetMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.status(200).body("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }
    
}
