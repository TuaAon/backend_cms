package com.main.backend_cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.backend_cms.model.Products;
import com.main.backend_cms.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
}
