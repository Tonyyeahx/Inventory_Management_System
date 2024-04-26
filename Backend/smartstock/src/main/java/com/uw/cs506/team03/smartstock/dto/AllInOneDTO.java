package com.uw.cs506.team03.smartstock.dto;

import java.util.Date;

/**
 * This class is the data transfer object for the all in one table
 */
public class AllInOneDTO {

    private int inventoryId;
    private int storeId;
    private int productId;
    private String productName;
    private int categoryId;
    private String categoryName;
    private float cost;
    private float sellPrice;
    private int quantity;
    private float discount;
    private Date lastOrderDate;
    private int orderQuantity;
    private int supplierId;
    private String supplierName;

    public AllInOneDTO() {
    }

    /**
     * This is the constructor for the AllInOneDTO class
     * @param inventoryId the id of the inventory
     * @param storeId the id of the store
     * @param productId the id of the product
     * @param productName the name of the product
     * @param categoryId the id of the category
     * @param categoryName the name of the category
     * @param cost the cost of the product
     * @param sellPrice the sell price of the product
     * @param quantity the quantity of the product
     * @param discount the discount of the product
     * @param lastOrderDate the last order date of the product
     * @param orderQuantity the order quantity of the product
     * @param supplierId the id of the supplier
     * @param supplierName the name of the supplier
     */
    public AllInOneDTO(int inventoryId, int storeId, int productId, String productName, int categoryId, String categoryName, float cost, float sellPrice, int quantity, float discount, Date lastOrderDate, int orderQuantity, int supplierId, String supplierName) {
        this.inventoryId = inventoryId;
        this.storeId = storeId;
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.cost = cost;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.lastOrderDate = lastOrderDate;
        this.orderQuantity = orderQuantity;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
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
     * This method is used to get the id of the store
     * @return the id of the store
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * This method is used to set the id of the store
     * @param storeId the id of the store
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * This method is used to get the id of the product
     * @return the id of the product
     */
    public int getProductId() {
        return productId;
    }

    /**
     * This method is used to set the id of the product
     * @param productId the id of the product
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * This method is used to get the name of the product
     * @return the name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method is used to set the name of the product
     * @param productName the name of the product
     */
    public void setProductName(String productName) {
        this.productName = productName;
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

    /**
     * This method is used to get the cost of the product
     * @return the cost of the product
     */
    public float getCost() {
        return cost;
    }

    /**
     * This method is used to set the cost of the product
     * @param cost the cost of the product
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * This method is used to get the sell price of the product
     * @return the sell price of the product
     */
    public float getSellPrice() {
        return sellPrice;
    }

    /**
     * This method is used to set the sell price of the product
     * @param sellPrice the sell price of the product
     */
    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method is used to get the quantity of the product
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method is used to set the quantity of the product
     * @param quantity the quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method is used to get the discount of the product
     * @return the discount of the product
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * This method is used to set the discount of the product
     * @param discount the discount of the product
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    /**
     * This method is used to get the last order date of the product
     * @return the last order date of the product
     */
    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    /**
     * This method is used to set the last order date of the product
     * @param lastOrderDate the last order date of the product
     */
    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    /**
     * This method is used to get the order quantity of the product
     * @return the order quantity of the product
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * This method is used to set the order quantity of the product
     * @param orderQuantity the order quantity of the product
     */
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * This method is used to get the id of the supplier
     * @return the id of the supplier
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * This method is used to set the id of the supplier
     * @param supplierId the id of the supplier
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method is used to get the name of the supplier
     * @return the name of the supplier
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method is used to set the name of the supplier
     * @param supplierName the name of the supplier
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * This method is used to get the string representation of the AllInOneDTO object
     */
    @Override
    public String toString() {
        return "AllInOneDTO{" +
                "inventoryId=" + inventoryId +
                ", storeId=" + storeId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", cost=" + cost +
                ", sellPrice=" + sellPrice +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", lastOrderDate=" + lastOrderDate +
                ", orderQuantity=" + orderQuantity +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}



