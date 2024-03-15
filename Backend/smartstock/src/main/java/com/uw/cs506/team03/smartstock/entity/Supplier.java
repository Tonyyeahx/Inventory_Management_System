package com.uw.cs506.team03.smartstock.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Supplier")

// This class is used to create an object that represents the supplier table in the database
public class Supplier {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "contact", nullable = false)
    private String contact;

    // Default constructor for Supplier object
    public Supplier() {

    }

    // Constructor for Supplier object
    public Supplier(int supplierId, String supplierName, String contact) {
        this.supplierName = supplierName;
        this.contact = contact;
    }

    // Getters and Setters for Supplier object
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // toString method for Supplier object
    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
    
}
