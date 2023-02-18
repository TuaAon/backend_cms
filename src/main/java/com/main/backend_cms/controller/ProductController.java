package com.main.backend_cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.service.ProductService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(200).body("ok");
    }
    
}
