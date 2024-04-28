package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

/**
 * This class is the entity for the inventory table
 */
@Entity
@Table(name = "inventory")
public class Inventory{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * This is the id of the inventory
     */
    @Column(name = "inventory_id", nullable = false)
    private int inventoryId;

    /**
     * This is the quantity of the product in the inventory
     */
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * This is the last order date of the product in the inventory
     */
    @Column(name = "last_order_date", nullable = false)
    private Date lastOrderDate;

    /**
     * This is the order quantity of the product in the inventory
     */
    @Column(name = "order_quantity", nullable = false)
    private int orderQuantity;

    /**
     * This is the discount of the product in the inventory
     */
    @Column(name = "discount", nullable = false)
    private float discount;

    /**
     * This is the sell price of the product in the inventory
     */
    @Column(name = "sell_price", nullable = false)
    private float sellPrice;

    /**
     * This is the product in the inventory
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    /**
     * This is the store of the inventory
     */
    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;

    /**
     * This is the default constructor for the Inventory class
     */
    public Inventory() {

    }
    
    /**
     * This is the constructor for the Inventory class
     * @param inventoryId the id of the inventory
     * @param storeId the id of the store
     * @param productId the id of the product
     * @param quantity the quantity of the product in the inventory
     * @param lastOrderDate the last order date of the product in the inventory
     * @param orderQuantity the order quantity of the product in the inventory
     * @param discount the discount of the product in the inventory
     * @param sellPrice the sell price of the product in the inventory
     */
    public Inventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.lastOrderDate = lastOrderDate;
        this.orderQuantity = orderQuantity;
        this.discount = discount;
        this.sellPrice = sellPrice;
    }

    /**
     * This method is used to get the id of the inventory
     * @return the id of the inventory
     */
    public int getInventoryId() {
        return inventoryId;
    }

    /**
     * This method is used to set the id of the inventory
     * @param inventoryId the id of the inventory
     */
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * This method is used to get the quantity of the product in the inventory
     * @return the quantity of the product in the inventory
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method is used to set the quantity of the product in the inventory
     * @param quantity the quantity of the product in the inventory
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method is used to get the last order date of the product in the inventory
     * @return the last order date of the product in the inventory
     */
    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    /**
     * This method is used to set the last order date of the product in the inventory
     * @param lastOrderDate the last order date of the product in the inventory
     */
    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    /**
     * This method is used to get the order quantity of the product in the inventory
     * @return the order quantity of the product in the inventory
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * This method is used to set the order quantity of the product in the inventory
     * @param orderQuantity the order quantity of the product in the inventory
     */
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * This method is used to get the discount of the product in the inventory
     * @return the discount of the product in the inventory
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * This method is used to set the discount of the product in the inventory
     * @param discount the discount of the product in the inventory
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    /**
     * This method is used to get the sell price of the product in the inventory
     * @return the sell price of the product in the inventory
     */
    public float getSellPrice() {
        return sellPrice;
    }

    /**
     * This method is used to set the sell price of the product in the inventory
     * @param sellPrice the sell price of the product in the inventory
     */
    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method is used to get the product in the inventory
     * @return product the product in the inventory
     */
    public Product getProduct() {
        return product;
    }

    /**
     * This method is used to set the product in the inventory
     * @param product the product in the inventory
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * This method is used to get the store of the inventory
     * @return store the store of the inventory
     */
    public Store getStore() {
        return store;
    }

    /**
     * This method is used to set the store of the inventory
     * @param store the store of the inventory
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * This method is used to add quantity to the product in the inventory
     * @param quantityToAdd the quantity to add to the product in the inventory
     */
    public void addQuantity(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    @Override
    /**
     * This method is used to get the string representation of the Inventory object
     * @return the string representation of the Inventory object
     */
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
