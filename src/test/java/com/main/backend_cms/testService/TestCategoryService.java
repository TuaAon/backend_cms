package com.main.backend_cms.testService;

import com.main.backend_cms.model.Category;
import com.main.backend_cms.repository.CategoryRepository;
import com.main.backend_cms.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestCategoryService {
    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    private Category category;

    @BeforeEach
    public void setup() {
        category = new Category("Shirt");
    }

    @Test
    public void should_return_category_when_call_getAllCategory_given_a_category(){
        when(categoryRepository.findAll()).thenReturn(List.of(category));
        List<Category> categories = categoryService.getAllCategories();

        assertThat(categories).isNotNull();
        assertThat(categories.size()).isEqualTo(1);
    }

    @Test
    public void should_return_category_when_call_createCategory_given_a_category() throws Exception {
        when(categoryRepository.save(category)).thenReturn(category);
        Category saveCategory = categoryService.createCategories(category);

        assertThat(saveCategory).isNotNull();
        verify(categoryRepository).save(category);
    }

    @Test
    public void should_return_throws_exception_when_call_createCategory_given_a_category_with_exist_name(){
        when(categoryRepository.findByName(category.getName())).thenReturn(Optional.of(category));

        org.junit.jupiter.api.Assertions.assertThrows(
                Exception.class, () -> {
                    categoryService.createCategories(category);
                });

        verify(categoryRepository, never()).save(any(Category.class));
    }

    @Test
    public void should_return_throws_exception_when_call_createCategory_given_a_category_with_null_name(){
        category.setName(null);

        org.junit.jupiter.api.Assertions.assertThrows(
                Exception.class, () -> {
                    categoryService.createCategories(category);
                });

        verify(categoryRepository, never()).save(any(Category.class));
    }
}
