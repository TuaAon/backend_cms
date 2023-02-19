package com.main.backend_cms.testService;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.repository.ProductRepository;
import com.main.backend_cms.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestProductService {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;
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
    public void should_return_List_Products_when_call_getAllProducts_given_product() {
        given(productRepository.findAll()).willReturn(List.of(product));

        List<Product> products = productService.getAllProducts();

        assertThat(products).isNotNull();
        assertThat(products.size()).isEqualTo(1);
    }

    @Test
    public void should_return_product_when_call_createProduct_given_product() throws Exception {
        given(productRepository.save(product)).willReturn(product);

        Product saveProduct = productService.createProduct(product);

        assertThat(saveProduct).isNotNull();
        verify(productRepository).save(product);
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_negative_amount() {
        product.setAmount(-10L);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_negative_price() {
        product.setPrice(-10.00);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_exist_name() {
        given(productRepository.findByName(product.getName())).willReturn(Optional.of(product));

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_null_name() {
        product.setName(null);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_null_price() {
        product.setPrice(null);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_null_amount() {
        product.setAmount(null);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_null_picture() {
        product.setPicture(null);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_createProduct_given_product_with_null_category() {
        product.setCategory(null);

        assertThrows(
                Exception.class, () -> {
                    productService.createProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_return_product_when_call_deleteProductByName_given_productName() throws Exception {
        given(productRepository.deleteByName(product.getName())).willReturn(product);
        given(productRepository.findByName(product.getName())).willReturn(Optional.of(product));

        Product deleteProduct = productService.deleteProductByName(product.getName());

        assertThat(deleteProduct).isNotNull();
        verify(productRepository).deleteByName(product.getName());
    }

    @Test
    public void should_throw_exception_when_call_deleteProductByName_given_non_exits_productName() {
        given(productRepository.findByName(product.getName())).willReturn(null);

        assertThrows(
                Exception.class, () -> {
                    productService.deleteProductByName(product.getName());
                });

        verify(productRepository, never()).deleteByName(product.getName());
    }

    @Test
    public void should_return_product_when_call_updateProduct_given_product() throws Exception {
        given(productRepository.save(product)).willReturn(product);
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));

        Product updateProduct = productService.updateProduct(product);

        assertThat(updateProduct).isNotNull();
        assertThat(updateProduct).isEqualTo(product);
        verify(productRepository).save(product);
    }

    @Test
    public void should_throw_exception_when_call_updateProduct_given_product_with_negative_amount() {
        product.setAmount(-10L);

        assertThrows(
                Exception.class, () -> {
                    productService.updateProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_updateProduct_given_product_with_negative_price() {
        product.setPrice(-10.00);

        assertThrows(
                Exception.class, () -> {
                    productService.updateProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_updateProduct_given_product_with_exist_name() {
        given(productRepository.findByName(product.getName())).willReturn(Optional.of(product));

        assertThrows(
                Exception.class, () -> {
                    productService.updateProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    public void should_throw_exception_when_call_updateProduct_given_non_exits_product() {
        given(productRepository.findByName(product.getName())).willReturn(null);

        assertThrows(
                Exception.class, () -> {
                    productService.updateProduct(product);
                });

        verify(productRepository, never()).save(any(Product.class));
    }
}
