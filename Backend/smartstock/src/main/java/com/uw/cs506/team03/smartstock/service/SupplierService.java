package com.uw.cs506.team03.smartstock.service;

import java.util.List;
import com.uw.cs506.team03.smartstock.entity.Supplier;

/**
 * This interface is the service for the supplier table
 */
public interface SupplierService {

    //==============================BASIC CRUD===================================

    /**
     * This method is used to find all the suppliers
     * @return the list of suppliers
     */
    public List<Supplier> findAll();

    /**
     * This method is used to find a supplier by its id
     * @param id the id of the supplier
     * @return the supplier
     */
    public Supplier findById(int id);

    /**
     * This method is used to save a supplier
     * @param supplier the supplier to be saved
     * @return the saved supplier
     */
    public Supplier save(Supplier supplier);

    /**
     * This method is used to delete a supplier by its id
     * @param id the id of the supplier
     */
    public void deleteById(int id);
}