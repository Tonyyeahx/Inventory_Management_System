package com.uw.cs506.team03.smartstock.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "product")

// This class is used to create an object that represents the product table in the database
public class Product {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes for Product object
    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "product_name", nullable = false, length = 30)
    private String productName;

    @Column(name = "cost", nullable = false)
    private float cost;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    // Default constructor for Product object
    public Product() {

    }

    // Constructor for Product object
    public Product(String productName, float cost, int categoryId, int supplierId) {
        this.productName = productName;
        this.cost = cost;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    // Getters and Setters for Product object
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    // toString method for Product object
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", cost=" + cost +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                '}';
    }
    
}
