package com.uw.cs506.team03.smartstock.dto;

import java.util.Date;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

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



