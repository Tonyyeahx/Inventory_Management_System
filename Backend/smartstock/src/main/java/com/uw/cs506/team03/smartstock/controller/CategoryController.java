package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the category table
 */
@RestController
public class CategoryController {

    CategoryService categoryService;

    /**
     * This is the constructor for the CategoryController class
     * @param categoryService the service for the category table
     */
    @Autowired
    public  CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * This method is used to get all the tuples in the category table
     * @return a list of all the tuples in the category table
     */
    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
    
    /**
     * This method is used to get a specific tuple in the category table
     * @param id the id of the tuple to be retrieved
     * @return the tuple with the specified id
     */
    @GetMapping("/categories/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }
    
    /**
     * This method is used to add a tuple to the category table
     * @param category the tuple to be added
     * @return the tuple that was added
     */
    @PostMapping("categories")
    public Category addTuple(@RequestBody Category category) {
        category.setCategoryId(0);
        Category theTuple = categoryService.save(category);
        return  theTuple;
    }
    
    /**
     * This method is used to update a tuple in the category table
     * @param category the updated tuple
     * @return the updated tuple
     */
    @PutMapping("categories")
    public Category updateTuple(@RequestBody Category category) {
        Category theTuple = categoryService.save(category);
        return  theTuple;
    }
    
    /**
     * This method is used to delete a tuple in the category table
     * @param id the id of the tuple to be deleted
     * @return a string indicating whether the deletion was successful
     */
    @DeleteMapping("categories/{id}")
    public String deleteTuple(@PathVariable int id) {
        Category theTuple = categoryService.findById(id);
        if(theTuple == null) {
            throw new RuntimeException("can not find tuple id " + id);
        }
        categoryService.deleteById(id);
        return "deleted tuple[id: " + id + "success";
    }
}
