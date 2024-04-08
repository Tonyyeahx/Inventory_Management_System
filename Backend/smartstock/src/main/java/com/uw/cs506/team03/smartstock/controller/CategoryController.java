package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public  CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
    //find one tuple in the inventory table by id
    @GetMapping("/categories/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }
    //add one tuple in the inventory table
    @PostMapping("categories")
    public Category addTuple(@RequestBody Category category) {
        category.setCategoryId(0);
        Category theTuple = categoryService.save(category);
        return  theTuple;
    }
    //update one tuple in the inventory table
    @PutMapping("categories")
    public Category updateTuple(@RequestBody Category category) {
        Category theTuple = categoryService.save(category);
        return  theTuple;
    }
    //delete one tuple in the inventory table
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
