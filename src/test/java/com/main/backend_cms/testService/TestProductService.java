package com.main.backend_cms.testService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.backend_cms.service.ProductService;

@SpringBootTest
public class TestProductService {
    
    @Autowired
    private ProductService productService;
    
    @Test
    void should_return_createsuccess_when_given_product(){
        
    }
}
