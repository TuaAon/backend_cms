package com.main.backend_cms.service;

import com.main.backend_cms.model.Category;
import com.main.backend_cms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) throws Exception {
        if (category.getName() != null && !categoryRepository.findByName(category.getName()).isPresent()) {
            return categoryRepository.save(category);
        }
        throw new Exception("Error");
    }

    public Category updateCategory(Category category) throws Exception {
        if (categoryRepository.findByName(category.getName()).isEmpty()) {
            Optional<Category> updatedCategory = categoryRepository.findById(category.getId());
            if (updatedCategory.isPresent()) {
                return categoryRepository.save(updatedCategory.get());
            }
        }
        throw new Exception("Error");
    }

}