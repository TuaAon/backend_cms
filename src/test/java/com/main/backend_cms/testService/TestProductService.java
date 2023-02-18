package com.main.backend_cms.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.backend_cms.model.Products;
import com.main.backend_cms.service.ProductService;

@SpringBootTest
public class TestProductService {
    
    @Autowired
    private ProductService productService;
}
