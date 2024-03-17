package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "contact", nullable = false)
    private String contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products;
    public Supplier() {

    }

    public Supplier(String supplierName, String contact) {
        this.supplierName = supplierName;
        this.contact = contact;
        this.products = new ArrayList<>();
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
    
}
