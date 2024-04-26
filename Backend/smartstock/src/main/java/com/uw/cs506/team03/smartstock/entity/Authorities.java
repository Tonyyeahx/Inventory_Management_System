package com.uw.cs506.team03.smartstock.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * This class is the entity for the authorities table
 */
@Entity
@Table(name = "authorities")
public class Authorities {

    /**
     * This is the username of the user
     */
    @Id
    @Column(name = "username")
    private String username;

    /**
     * This is the authority of the user
     */
    @Column(name = "authority")
    private String authority;

    /**
     * This is the default constructor for the Authorities class
     */
    public Authorities() {
    }

    /**
     * This is the constructor for the Authorities class
     * @param username the username
     * @param authority the authority
     */
    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
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
     * This method is used to get the authority
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * This method is used to set the authority
     * @param authority the authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * This method is used to get the string representation of the Authorities object
     * @return the string representation of the Authorities object
     */
    @Override
    public String toString() {
        return "Authorities{" +
                "username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}

