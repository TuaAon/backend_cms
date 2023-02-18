package com.main.backend_cms.service;

import com.main.backend_cms.model.Category;
import com.main.backend_cms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return  categoryRepository.findAll();
    }

    public String createCategory(Category category){
        if (category.getName() != null && !categoryRepository.findByName(category.getName()).isPresent()){
            categoryRepository.save(category);
            return "Create success";
        }
        return "Create fail";
    }
}