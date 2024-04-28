package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * This class is the entity for the store table
 */
@Entity
@Table(name = "store")
public class Store {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * This is the id of the store
     */
    @Column(name = "store_id")
    private int storeId;

    /**
     * This is the longitude of the store
     */
    @Column(name = "longitude", nullable = false) // set to not null
    private float longitude;

    /**
     * This is the latitude of the store
     */
    @Column(name = "latitude", nullable = false)
    private float latitude;

    /**
     * This is the manager of the store
     */
    @Column(name = "manager", nullable = false, length = 30)
    private String manager;

    /**
     * This is the open date of the store
     */
    @Column(name = "open_date", nullable = false)
    private Date openDate;

    /**
     * This is the contact of the store
     */
    @Column(name = "contact", nullable = false, length = 10)
    private String contact;

    /**
     * This is the list of inventories of the store
     */
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Inventory> inventories;

    /**
     * This is the default constructor for the Store class
     */
    public Store() {

    }

    /**
     * This is the constructor for the Store class
     * @param longitude the longitude of the store
     * @param latitude the latitude of the store
     * @param manager the manager of the store
     * @param openDate the open date of the store
     * @param contact the contact of the store
     */
    public Store(float longitude, float latitude, String manager, Date openDate, String contact) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.manager = manager;
        this.openDate = openDate;
        this.contact = contact;
        this.inventories = new ArrayList<>();
    }

    /**
     * This method is used to get the id
     * @return the id
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * This method is used to set the id
     * @param storeId the id
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * This method is used to get the longitude
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * This method is used to set the longitude
     * @param longitude the longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * This method is used to get the latitude
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * This method is used to set the latitude
     * @param latitude the latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * This method is used to get the manager
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * This method is used to set the manager
     * @param manager the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * This method is used to get the open date
     * @return the open date
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * This method is used to set the open date
     * @param openDate the open date
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
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
     * This method is used to get the list of inventories
     * @return the list of inventories
     */
    public List<Inventory> getInventories() {
        return inventories;
    }

    /**
     * This method is used to set the list of inventories
     * @param inventories the list of inventories
     */
    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    /**
     * This method is used to convert the store object to a string
     */
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
