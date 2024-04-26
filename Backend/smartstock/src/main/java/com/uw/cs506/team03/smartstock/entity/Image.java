package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

/**
 * This class is the entity for the image table
 */
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * This is the id of the image
     */
    @Column(name = "image_id", nullable = false)
    private Long id;

    /**
     * This is the data of the image
     */
    @Lob
    private byte[] data;

    /**
     * This is the default constructor for the Image class
     */
    public Image() {
    }

    /**
     * This is the constructor for the Image class
     * @param data the data of the image
     */
    public Image(byte[] data) {
        this.data = data;
    }

    /**
     * This method is used to get the id
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * This method is used to set the id
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method is used to get the data
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * This method is used to set the data
     * @param data the data
     */
    public void setData(byte[] data) {
        this.data = data;
    }
}