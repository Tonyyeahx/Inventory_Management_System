package com.uw.cs506.team03.smartstock.service;

import java.util.List;

import com.uw.cs506.team03.smartstock.entity.Store;

/**
 * This interface is the service for the store table
 */
public interface StoreService {
    
    //==============================BASIC CRUD===================================

    /**
     * This method is used to find all the stores
     * @return the list of stores
     */
    public List<Store> findAll();

    /**
     * This method is used to find a store by its id
     * @param id the id of the store
     * @return the store
     */
    public Store findById(int id);

    /**
     * This method is used to save a store
     * @param store the store to be saved
     * @return the saved store
     */
    public Store save(Store store);

    /**
     * This method is used to delete a store by its id
     * @param id the id of the store
     */
    public void deleteById(int id);
}