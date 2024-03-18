package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventory")

// This class is used to create an object that represents the inventory table in the database
public class Inventory{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes for Inventory object
    @Column(name = "inventory_id", nullable = false)
    private int inventoryId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "last_order_date", nullable = false)
    private Date lastOrderDate;

    @Column(name = "order_quantity", nullable = false)
    private int orderQuantity;

    @Column(name = "discount", nullable = false)
    private float discount;

    @Column(name = "sell_price", nullable = false)
    private float sellPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    // Default constructor for Inventory object
    public Inventory() {

    }
    
    // Constructor for Inventory object
    public Inventory(int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        this.quantity = quantity;
        this.lastOrderDate = lastOrderDate;
        this.orderQuantity = orderQuantity;
        this.discount = discount;
        this.sellPrice = sellPrice;
    }

    // Getters and Setters for Inventory object
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }



    // Method to add quantity to a product within the inventory
    public void addQuantity(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    // Override toString method for Inventory object
    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventoryId +
                ", quantity=" + quantity +
                ", last_order_date=" + lastOrderDate +
                ", order_quantity=" + orderQuantity +
                ", discount=" + discount +
                ", sell_price=" + sellPrice +
                '}';
    }
}
