package com.uw.cs506.team03.smartstock.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes
    @Column(name = "image_id", nullable = false)
    private Long id;

    private String type;

    @Lob
    private byte[] data;

    // Default constructor
    public Image() {
    }

    // Constructor
    public Image(String type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}