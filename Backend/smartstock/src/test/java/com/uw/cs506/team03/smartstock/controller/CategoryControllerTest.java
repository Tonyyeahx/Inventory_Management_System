package com.uw.cs506.team03.smartstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest annotation is used for Spring MVC tests
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private Category category;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    public void setup() {
        // Use the constructor with categoryName to create a new Category instance
        category = new Category("Test Category");
        category.setCategoryId(1); // Simulate the ID set by the database
    }

    // @Test annotation is used to signal that the annotated method is a test method
    @Test
    @WithMockUser(roles = "Manager")
    // testFindAll() method tests the findAll() method in the CategoryController class
    public void testFindAll() throws Exception {
        List<Category> categories = Arrays.asList(category);
        when(categoryService.findAll()).thenReturn(categories);

        // Perform a GET request to the "/categories" endpoint
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].categoryId").value(category.getCategoryId()))
                .andExpect(jsonPath("$[0].categoryName").value("Test Category"));

        verify(categoryService, times(1)).findAll();
    }

    @Test
    @WithMockUser(roles = "Manager")
    // testFindById() method tests the findById() method in the CategoryController class
    public void testFindById() throws Exception {
        when(categoryService.findById(1)).thenReturn(category);

        mockMvc.perform(get("/categories/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.categoryName").value("Test Category"));

        verify(categoryService, times(1)).findById(1);
    }

    @Test
    @WithMockUser(roles = "Manager")
    // testAddTuple() method tests the addTuple() method in the CategoryController class
    public void testAddTuple() throws Exception {
        when(categoryService.save(any(Category.class))).thenReturn(category);

        String categoryJson = new ObjectMapper().writeValueAsString(
            Map.of("categoryName", "Test Category")
        );

        mockMvc.perform(post("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.categoryName").value("Test Category"));

        verify(categoryService, times(1)).save(any(Category.class));
    }

    @Test
    @WithMockUser(roles = "Manager")
    // testUpdateTuple() method tests the updateTuple() method in the CategoryController class
    public void testUpdateTuple() throws Exception {
        when(categoryService.save(any(Category.class))).thenReturn(category);

        String categoryJson = new ObjectMapper().writeValueAsString(
            Map.of("categoryName", "Test Category", "categoryId", 1)
        );

        mockMvc.perform(put("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.categoryName").value("Test Category"));

        verify(categoryService, times(1)).save(any(Category.class));
    }

    @Test
    @WithMockUser(roles = "Manager")
    // testDeleteTuple() method tests the deleteTuple() method in the CategoryController class
    public void testDeleteTuple() throws Exception {
        doNothing().when(categoryService).deleteById(1);
        when(categoryService.findById(1)).thenReturn(category);

        mockMvc.perform(delete("/categories/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("deleted tuple[id: 1success"));

        verify(categoryService, times(1)).deleteById(1);
    }
}