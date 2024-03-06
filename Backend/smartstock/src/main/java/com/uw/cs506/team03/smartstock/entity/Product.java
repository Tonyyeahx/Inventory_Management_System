package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "product")
public class Product {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "product_name", nullable = false, length = 30)
    private String productName;

    @Column(name = "sell_price", nullable = false)
    private float sellPrice;

    @Column(name = "discount", nullable = false)
    private float discount;

    @Column(name = "cost", nullable = false)
    private float cost;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    public Product() {

    }

    public Product(String productName, float sellPrice, float discount, float cost, int categoryId, int supplierId) {
        this.productName = productName;
        this.sellPrice = sellPrice;
        this.discount = discount;
        this.cost = cost;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

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

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", sellPrice=" + sellPrice +
                ", discount=" + discount +
                ", cost=" + cost +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                '}';
    }
    
}
