package com.uw.cs506.team03.smartstock.service;

import java.util.List;

import com.uw.cs506.team03.smartstock.entity.Product;

public interface ProductService {

    public String setProductCost(Integer productId, Integer targetCost);
 
    //==============================BASIC CRUD===================================
    public List<Product> findAll();

    public Product findById(int id);

    public Product save(Product product);

    public void deleteById(int id);
}