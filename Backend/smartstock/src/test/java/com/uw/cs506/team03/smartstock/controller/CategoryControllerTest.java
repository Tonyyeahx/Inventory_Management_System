package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private CategoryService categoryService;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private CategoryController categoryController;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // test findAll method
    void findAll_shouldReturnListOfCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Category 1"));
        categories.add(new Category("Category 2"));

        // Given
        when(categoryService.findAll()).thenReturn(categories);

        // When
        List<Category> result = categoryController.findAll();

        // Then
        assertEquals(categories, result);
        verify(categoryService, times(1)).findAll();
    }

    @Test
    // test findById method
    void findById_shouldReturnCategoryById() {
        // Given
        int categoryId = 1;
        Category category = new Category("Category 1");
        category.setCategoryId(categoryId);

        // When
        when(categoryService.findById(categoryId)).thenReturn(category);

        Category result = categoryController.findById(categoryId);

        // Then
        assertEquals(category, result);
        verify(categoryService, times(1)).findById(categoryId);
    }

    @Test
    // test addTuple method
    void addTuple_shouldAddCategoryAndReturnAddedCategory() {
        Category category = new Category("New Category");
        Category addedCategory = new Category("New Category");
        addedCategory.setCategoryId(1);

        when(categoryService.save(category)).thenReturn(addedCategory);

        Category result = categoryController.addTuple(category);

        assertEquals(addedCategory, result);
        verify(categoryService, times(1)).save(category);
    }

    @Test
    // test updateTuple method
    void updateTuple_shouldUpdateCategoryAndReturnUpdatedCategory() {
        Category category = new Category("Updated Category");
        category.setCategoryId(1);

        when(categoryService.save(category)).thenReturn(category);

        Category result = categoryController.updateTuple(category);

        assertEquals(category, result);
        verify(categoryService, times(1)).save(category);
    }

    @Test
    // test deleteTuple method
    void deleteTuple_shouldDeleteCategoryAndReturnSuccessMessage() {
        int categoryId = 1;
        Category category = new Category("Category 1");
        category.setCategoryId(categoryId);

        when(categoryService.findById(categoryId)).thenReturn(category);

        String result = categoryController.deleteTuple(categoryId);

        assertEquals("deleted tuple[id: " + categoryId + "success", result);
        verify(categoryService, times(1)).findById(categoryId);
        verify(categoryService, times(1)).deleteById(categoryId);
    }
}