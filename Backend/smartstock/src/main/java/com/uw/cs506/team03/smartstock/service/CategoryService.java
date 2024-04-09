package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Inventory;

import java.util.List;

public interface CategoryService {

    //==============================BASIC CRUD===================================
    public List<Category> findAll();

    public Category findById(int id);

    public Category save(Category category);

    public void deleteById(int id);
}