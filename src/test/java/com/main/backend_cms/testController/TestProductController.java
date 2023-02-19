package com.main.backend_cms.testController;

import com.main.backend_cms.controller.ProductController;
import com.main.backend_cms.model.Product;
import com.main.backend_cms.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class TestProductController {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    private Product product;

    @BeforeEach
    public void setup() {
        product = new Product("shirt",
                12.12,
                90L,
                "good shirt",
                new String[]{"1", "3"},
                "pic of shirt");
    }

    @Test
    public void should_return_List_Product_when_call_getAllProducts_given_product() {
        given(productService.getAllProducts()).willReturn(List.of(product));

        ResponseEntity<?> response = productController.getAllProducts();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(List.of(product));
        verify(productService).getAllProducts();
    }

    @Test
    public void should_return_200_and_product_when_call_createProduct_given_product() throws Exception {
        given(productService.createProduct(product)).willReturn(product);

        ResponseEntity<?> response = productController.createProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(product);
        verify(productService).createProduct(product);

    }

    @Test
    public void should_return_400_and_product_when_call_createProduct_given_product() throws Exception {
        given(productService.createProduct(product)).willReturn(product);

        ResponseEntity<?> response = productController.createProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(product);
        verify(productService).createProduct(product);

    }
}
