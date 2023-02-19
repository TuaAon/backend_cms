package com.main.backend_cms.testController;

import com.main.backend_cms.controller.CategoryController;
import com.main.backend_cms.model.Category;
import com.main.backend_cms.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestCategoryController {

    @InjectMocks
    private CategoryController categoryController;
    @Mock
    private CategoryService categoryService;
    @Test
    void should_return_product_correctly_list_when_call_allCategory(){
        // Given
        // When
        ResponseEntity<?> result = categoryController.getAllCategory();
        // Then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void should_return_status_200_when_call_allCategory(){
        // Given
        Category category1 = new Category("Shirt");
        Category category2 = new Category("Hat");
        List<Category> categories = Arrays.asList(category1, category2);

        // When
        ResponseEntity<?> result = categoryController.getAllCategory();

        // Then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
