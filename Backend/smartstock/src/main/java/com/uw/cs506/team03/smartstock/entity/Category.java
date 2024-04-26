package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * This class is the entity for the category table
 */
@Entity
@Table(name = "category")
public class Category {

    /**
     * This is the id of the category
     */
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    /**
     * This is the name of the category
     */
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    /**
     * This is the list of products in the category
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * This is the default constructor for the Category class
     */
    public Category() {

    }

    /**
     * This is the constructor for the Category class
     * @param categoryName the name of the category
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    /**
     * This method is used to get the products
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * This method is used to set the products
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * This method is used to get the id of the category
     * @return the id of the category
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * This method is used to set the id of the category
     * @param categoryId the id of the category
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method is used to get the name of the category
     * @return the name of the category
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method is used to set the name of the category
     * @param categoryName the name of the category
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    /**
     * This method is used to get the string representation of the category
     * @return the string representation of the category
     */
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
    
}
