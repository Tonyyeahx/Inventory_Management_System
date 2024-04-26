package com.uw.cs506.team03.smartstock.service;

import java.util.List;

import com.uw.cs506.team03.smartstock.entity.Product;

/**
 * This interface is the service for the product table
 */
public interface ProductService {

    /**
     * This method is used to find a product by its id
     * @param productId the id of the product
     * @param targetCost the target cost of the product
     * @return the product
     */
    public String setProductCost(Integer productId, Integer targetCost);
 
    //==============================BASIC CRUD===================================

    /**
     * This method is used to find all the products
     * @return the list of products
     */
    public List<Product> findAll();

    /**
     * This method is used to find a product by its id
     * @param id the id of the product
     * @return the product
     */
    public Product findById(int id);

    /**
     * This method is used to save a product
     * @param product the product to be saved
     * @return the saved product
     */
    public Product save(Product product);

    /**
     * This method is used to delete a product by its id
     * @param id the id of the product
     */
    public void deleteById(int id);
}