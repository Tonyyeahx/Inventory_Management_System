package com.uw.cs506.team03.smartstock.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "category")

// This class is used to create an object that represents the category table in the database
public class Category {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes for Category object
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    // Default constructor for Category object
    public Category() {

    }

    // Constructor for Category object
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getters and Setters for Category object
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // toString method for Category object
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
    
}
