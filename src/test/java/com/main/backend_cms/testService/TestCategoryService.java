package com.main.backend_cms.testService;

import com.main.backend_cms.model.Category;
import com.main.backend_cms.service.CategoryService;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestCategoryService {
    @InjectMocks
    private CategoryService categoryService;
    private Category category;

    @Test
    void should_return_200_when_call_get_all_category(){
        List<Category> test = categoryService.getAllCategory();
    }
    @Test
    void should_return_success_when_call_create_new_category(){
        Category category = new Category("jean");
        String test = categoryService.createCategory(category);
        assertEquals("Create success",test);
    }
}
