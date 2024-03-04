package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Inventory")
public class Inventory{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID", nullable = false)
    private int inventoryId;

    @Column(name = "StoreID", nullable = false)
    private int storeId;

    @Column(name = "ProductID", nullable = false) // set to not null
    private int productId;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "LastOrderDate", nullable = false)
    private Date lastOrderDate;

    @Column(name = "OrderQuantity", nullable = false)
    private int orderQuantity;

    public Inventory() {

    }
    
    public Inventory(int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity) {
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
        this.lastOrderDate = lastOrderDate;
        this.orderQuantity = orderQuantity;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", storeId=" + storeId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", lastOrderDate=" + lastOrderDate +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}

