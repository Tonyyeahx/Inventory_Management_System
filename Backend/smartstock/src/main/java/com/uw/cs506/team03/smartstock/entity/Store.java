package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "store")
public class Store {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "longitude", nullable = false) // set to not null
    private float longitude;

    @Column(name = "latitude", nullable = false)
    private float latitude;

    @Column(name = "manager", nullable = false, length = 30)
    private String manager;

    @Column(name = "open_data", nullable = false)
    private Date openDate;

    @Column(name = "contact", nullable = false, length = 10)
    private String contact;


    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Inventory> inventories;



    public Store() {

    }

    public Store(float longitude, float latitude, String manager, Date openDate, String contact) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.manager = manager;
        this.openDate = openDate;
        this.contact = contact;
        this.inventories = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", manager='" + manager + '\'' +
                ", openDate=" + openDate +
                ", contact='" + contact + '\'' +
                '}';
    }
}
