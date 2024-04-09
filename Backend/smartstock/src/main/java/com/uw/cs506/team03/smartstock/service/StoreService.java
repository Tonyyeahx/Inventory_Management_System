package com.uw.cs506.team03.smartstock.service;

import java.util.List;

import com.uw.cs506.team03.smartstock.entity.Store;

public interface StoreService {
    
    //==============================BASIC CRUD===================================
    public List<Store> findAll();

    public Store findById(int id);

    public Store save(Store store);

    public void deleteById(int id);
}