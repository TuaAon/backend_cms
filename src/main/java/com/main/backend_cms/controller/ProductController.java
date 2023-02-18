package com.main.backend_cms.controller;

import org.springframework.web.bind.annotation.RestController;

import com.main.backend_cms.model.Products;
import com.main.backend_cms.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/showProduct") //Mockup for testing
    public ResponseEntity<?> getAllProduct(){
        try {
            return ResponseEntity.status(200).body(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }

    @PostMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Products product) {
        try {
            String data = productService.createProduct(product);
            if(data == "Create success"){
                return ResponseEntity.status(200).body(data);
            } else {
                return ResponseEntity.status(400).body("can't create product");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }
    
}
