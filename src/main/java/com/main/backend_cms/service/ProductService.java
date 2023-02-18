package com.main.backend_cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
