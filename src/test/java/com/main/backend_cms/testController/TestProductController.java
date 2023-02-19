package com.main.backend_cms.testController;

import com.main.backend_cms.controller.ProductController;
import com.main.backend_cms.service.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestProductController {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;


}
