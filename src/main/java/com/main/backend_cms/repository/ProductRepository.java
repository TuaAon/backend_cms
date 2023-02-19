package com.main.backend_cms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.backend_cms.model.Product;

import java.util.Optional;

public interface ProductRepository 
    extends MongoRepository <Product, String> {
    Optional<Product> findByName(String name);
}
