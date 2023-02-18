package com.main.backend_cms.repository;

import com.main.backend_cms.model.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Categories, String> {
    Optional<Categories> findByName(String name);
}
