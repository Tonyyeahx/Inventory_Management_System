package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Inventory")
public class Inventory{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private int inventoryId;

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity_id", nullable = false)
    private int quantity;

    @Column(name = "last_order_date", nullable = false)
    private Date lastOrderDate;

    @Column(name = "order_quantity", nullable = false)
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

    public void addQuantity(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventoryId +
                ", store_id=" + storeId +
                ", product_id=" + productId +
                ", quantity=" + quantity +
                ", last_order_date=" + lastOrderDate +
                ", order_quantity=" + orderQuantity +
                '}';
    }
}

