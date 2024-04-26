package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * This class is the entity for the supplier table
 */
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * This is the id of the supplier
     */
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    /**
     * This is the name of the supplier
     */
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    /**
     * This is the contact of the supplier
     */
    @Column(name = "contact", nullable = false)
    private String contact;

    /**
     * This is the list of products of the supplier
     */
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * This is the default constructor for the Supplier class
     */
    public Supplier() {

    }

    /**
     * This is the constructor for the Supplier class
     * @param supplierName the name of the supplier
     * @param contact the contact of the supplier
     */
    public Supplier(String supplierName, String contact) {
        this.supplierName = supplierName;
        this.contact = contact;
        this.products = new ArrayList<>();
    }

    /**
     * This method is used to get the id
     * @return the id
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * This method is used to set the id
     * @param supplierId the id
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method is used to get the name
     * @return the name
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method is used to set the name
     * @param supplierName the name
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * This method is used to get the contact
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method is used to set the contact
     * @param contact the contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * This method is used to get the products
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * This method is used to set the products
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    /**
     * This method is used to get the string representation of the Supplier object
     * @return the string representation of the Supplier object
     */
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
    
}
