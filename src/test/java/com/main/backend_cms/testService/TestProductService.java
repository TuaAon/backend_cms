package com.main.backend_cms.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.main.backend_cms.service.ProductService;

@SpringBootTest
public class TestProductService {
    
    @MockBean
    private ProductService productService;
    
    @Test
    public void test() {
        assertEquals("s", "s");
    }
}
