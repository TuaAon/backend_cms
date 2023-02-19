package com.main.backend_cms.testController;

import com.main.backend_cms.controller.CategoryController;
import com.main.backend_cms.model.Category;
import com.main.backend_cms.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestCategoryController {
    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private CategoryController categoryController;


    private Category category1, category2;

    @BeforeEach
    public void setup() {
        category1 = new Category("Shirt");
        category2 = new Category("Hat");
    }

    // GetMapping
    @Test
    public void should_return_category_correctly_list_when_call_getAllCategories() {
        // Given
        List<Category> categories = Arrays.asList(category1, category2);

        // When
        when(categoryService.getAllCategories()).thenReturn(categories);
        ResponseEntity<?> result = categoryController.getAllCategories();

        // Then
        assertThat(result.getBody()).isEqualTo(categories);
    }

    @Test
    public void should_return_status_200_when_call_getAllCategories_and_category_is_not_empty() {
        // Given
        List<Category> categories = Arrays.asList(category1, category2);
        // When
        when(categoryService.getAllCategories()).thenReturn(categories);
        ResponseEntity<?> result = categoryController.getAllCategories();
        // Then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    // PostMapping
    @Test
    public void should_return_status_200_when_call_createCategory_given_not_exist_name() throws Exception {
        // Given
        when(categoryService.createCategory(category1)).thenReturn(category1);
        // When

        ResponseEntity<?> responseEntity = categoryController.createCategory(category1);

        // Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(category1);
        verify(categoryService).createCategory(category1);
    }

    @Test
    public void should_return_status_400_when_call_createCategory_given_exception() throws Exception {
        // Given
        when(categoryService.createCategory(category1)).thenThrow(Exception.class);
        // When

        ResponseEntity<?> responseEntity = categoryController.createCategory(category1);

        // Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
