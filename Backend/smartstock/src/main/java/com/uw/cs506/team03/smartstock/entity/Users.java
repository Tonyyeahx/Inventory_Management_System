package com.uw.cs506.team03.smartstock.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the entity for the users table
 */
@Entity
@Table(name = "users")
public class Users {
    
    @Id
    /**
     * This is the username of the user
     */
    @Column(name = "username")
    private String username;

    /**
     * This is the password of the user
     */
    @Column(name = "password")
    private String password;

    /**
     * This is the enabled status of the user
     */
    @Column(name = "enabled")
    private Integer enabled;

    /**
     * This is the store id of the user
     */
    @Column(name = "store_id")
    private Integer store_id;

    public Users() {

    }

    /**
     * This is the constructor for the Users class
     * @param username the username of the user
     * @param password the password of the user
     * @param enabled the enabled status of the user
     * @param store_id the store id of the user
     */
    public Users(String username, String password, int enabled, int store_id) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.store_id = store_id;
    }

    /**
     * This method is used to get the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method is used to set the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method is used to get the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to set the password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method is used to get the enabled status
     * @return the enabled status
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * This method is used to set the enabled status
     * @param enabled the enabled status
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    /**
     * This method is used to get the store id
     * @return the store id
     */
    public Integer getStore_id() {
        return store_id;
    }

    /**
     * This method is used to set the store id
     * @param store_id the store id
     */
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    @Override
    /**
     * This method is used to get the string representation of the Users object
     * @return the string representation of the Users object
     */
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled='" + enabled + '\'' +
                ", store_id=" + store_id +
                '}';
    }
}
