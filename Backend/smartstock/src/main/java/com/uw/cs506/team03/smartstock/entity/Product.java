package com.uw.cs506.team03.smartstock.entity;
import java.util.List;
import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "product")

/**
 * This class is the entity for the product table
 */
public class Product {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * This is the id of the product
     */
    @Column(name = "product_id", nullable = false)
    private int productId;

    /**
     * This is the name of the product
     */
    @Column(name = "product_name", nullable = false, length = 30)
    private String productName;

    /**
     * This is the cost of the product
     */
    @Column(name = "cost", nullable = false)
    private float cost;

    /**
     * This is the category of the product
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    /**
     * This is the supplier of the product
     */
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    private Supplier supplier;

    /**
     * This is the list of inventories of the product
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Inventory> inventories;

    /**
     * This is the image of the product
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image image;

    public Product() {

    }

    /**
     * This is the constructor for the Product class
     * @param productName the name of the product
     * @param cost the cost of the product
     * @param categoryId the category id of the product
     * @param supplierId the supplier id of the product
     * @param image the image of the product
     */
    public Product(String productName, float cost, int categoryId, int supplierId, Image image) {
        this.productName = productName;
        this.cost = cost;
        this.inventories = new ArrayList<>();
        this.image = image;
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
     * This method is used to get the category of the product
     * @return the category of the product
     */
    public Category getCategory() {
        return category;
    }

    /**
     * This method is used to set the category of the product
     * @param category the category of the product
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * This method is used to get the supplier of the product
     * @return the supplier of the product
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * This method is used to set the supplier of the product
     * @param supplier the supplier of the product
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    /**
     * This method is used to get the inventories
     * @return the inventories
     */
    public List<Inventory> getInventories() {
        return inventories;
    }

    /**
     * This method is used to set the inventories
     * @param inventories the inventories
     */
    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    
    @Override
    /**
     * This method is used to get the string representation of the Product object
     */
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", cost=" + cost +
                '}';
    }
    
}
