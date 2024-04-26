package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Inventory;

import java.util.List;

/**
 * This class is the service for the category table
 */
public interface CategoryService {

    //==============================BASIC CRUD===================================

    /**
     * This method is used to find all the categories
     * @return the list of categories
     */
    public List<Category> findAll();

    /**
     * This method is used to find a category by its id
     * @param id the id of the category
     * @return the category
     */
    public Category findById(int id);

    /**
     * This method is used to save a category
     * @param category the category to be saved
     * @return the saved category
     */
    public Category save(Category category);

    /**
     * This method is used to delete a category by its id
     * @param id the id of the category
     */
    public void deleteById(int id);
}