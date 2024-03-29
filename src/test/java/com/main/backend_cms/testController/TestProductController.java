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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
    public void should_return_success_when_call_getAllProducts_given_product() {
        given(productService.getAllProducts()).willReturn(List.of(product));

        ResponseEntity<?> response = productController.getAllProducts();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(List.of(product));
        verify(productService).getAllProducts();
    }

    @Test
    public void should_return_success_when_call_createProduct_given_product() throws Exception {
        given(productService.createProduct(product)).willReturn(product);

        ResponseEntity<?> response = productController.createProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(product);
        verify(productService).createProduct(product);

    }

    @Test
    public void should_return_failed_when_call_createProduct_given_service_throw_exception() throws Exception {
        given(productService.createProduct(product)).willThrow(Exception.class);

        ResponseEntity<?> response = productController.createProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    }

    @Test
    public void should_return_success_when_call_deleteProductByName_given_productName() throws Exception {
        given(productService.deleteProductByName(product.getName())).willReturn(product);

        ResponseEntity<?> response = productController.deleteProductByName(product.getName());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(product);
        verify(productService).deleteProductByName(product.getName());
    }

    @Test
    public void should_return_failed_when_call_deleteProductByName_given_service_throw_exception() throws Exception {
        given(productService.deleteProductByName(product.getName())).willThrow(Exception.class);

        ResponseEntity<?> response = productController.deleteProductByName(product.getName());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void should_return_success_when_call_updateProduct_given_product() throws Exception {
        given(productService.updateProduct(product)).willReturn(product);

        ResponseEntity<?> response = productController.updateProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(product);
        verify(productService).updateProduct(product);
    }

    @Test
    public void should_return_failed_when_call_updateProduct_given_service_throw_exception() throws Exception {
        given(productService.updateProduct(product)).willThrow(Exception.class);

        ResponseEntity<?> response = productController.updateProduct(product);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
