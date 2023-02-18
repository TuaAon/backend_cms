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
    
    @Test
    void should_return_createsuccess_when_call_createproduct_given_product(){
        Products product = new Products("pName", 
                                99.99, 
                                100, 
                                "pName is a very good product", 
                                "catid", 
                                "pNamePic");
        String data = productService.createProduct(product);
        assertEquals(data, "Create success");
    }
}
