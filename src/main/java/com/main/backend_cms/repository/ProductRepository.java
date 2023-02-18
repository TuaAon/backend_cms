package com.main.backend_cms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.backend_cms.model.Products;

public interface ProductRepository 
    extends MongoRepository <Products, String> {
    
}
