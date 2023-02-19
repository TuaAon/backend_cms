package com.main.backend_cms.controller;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/showProducts") //Mockup for testing
    public ResponseEntity<?> getAllProducts(){
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.status(200).body(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("server error");
        }
    }

    @PostMapping(value="/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
                return ResponseEntity.status(200).body(productService.createProduct(product));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("create failed");
        }
    }

    @PutMapping(value = "/updateProductByName")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        try {
            //TODO: implement updateProduct
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping(value = "/deleteProductByName")
    public ResponseEntity<?> deleteProductByName(@RequestBody String productName){
        try {
            //TODO: implement deleteProduct
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
    
}
