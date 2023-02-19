package com.main.backend_cms.controller;

import com.main.backend_cms.model.Category;
import com.main.backend_cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/showCategory")
    public ResponseEntity<?> getAllCategory(){
        try{
            return ResponseEntity.status(200).body(categoryService.getAllCategory());
        } catch (Exception ex){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @PostMapping(value = "/createCategory")

    public ResponseEntity<?> createCategory(@RequestBody Category category){
        try{
            return ResponseEntity.status(200).body(category);
        } catch (Exception ex){
            return ResponseEntity.status(500).body("Error");
        }
    }

}
