package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryServiceImpTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private CategoryRepository categoryRepository;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private CategoryServiceImp categoryService;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test annotation is used to signal that the annotated method is a test method
    @Test
    void findAll() {
        // Given
        Category category1 = new Category("Meat"); 
        Category category2 = new Category("Vegetable");
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        // When
        List<Category> result = categoryService.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(categoryRepository).findAll();
    }

    @Test
    void findById() {
        // Given
        int categoryId = 1;
        Category category = new Category("Meat"); 
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        // When
        Category result = categoryService.findById(categoryId);

        // Then
        assertNotNull(result);
        verify(categoryRepository).findById(categoryId);
    }

    @Test
    void findById_NotFound() {
        // Given
        int categoryId = 1;
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        // When & Then
        Exception exception = assertThrows(RuntimeException.class, () -> categoryService.findById(categoryId));
        assertTrue(exception.getMessage().contains("Do not find tuple id " + categoryId));
    }

    @Test
    void save() {
        // Given
        Category category = new Category(); // Assume Category has a no-arg constructor
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // When
        Category savedCategory = categoryService.save(category);

        // Then
        assertNotNull(savedCategory);
        verify(categoryRepository).save(any(Category.class));
    }

    @Test
    void deleteById() {
        // Given
        int categoryId = 1;

        // When
        categoryService.deleteById(categoryId);

        // Then
        verify(categoryRepository).deleteById(categoryId);
    }
}