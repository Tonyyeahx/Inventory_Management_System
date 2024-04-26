package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.repository.CategoryRepository;
import com.uw.cs506.team03.smartstock.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the category table
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * This method is used to find all the categories
     * @return the list of categories
     */
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * This method is used to find a category by its id
     * @param id the id of the category
     * @return the category
     */
    @Override
    public Category findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return category.get();
        }
        else {
            throw new RuntimeException("Do not find tuple id " + id);
        }
    }

    /**
     * This method is used to save a category
     * @param category the category to be saved
     * @return the saved category
     */
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * This method is used to delete a category by its id
     * @param id the id of the category
     */
    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
