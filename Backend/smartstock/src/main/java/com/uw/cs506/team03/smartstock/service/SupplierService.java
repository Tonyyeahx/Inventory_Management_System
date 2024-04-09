package com.uw.cs506.team03.smartstock.service;

import java.util.List;
import com.uw.cs506.team03.smartstock.entity.Supplier;


public interface SupplierService {

    //==============================BASIC CRUD===================================
    public List<Supplier> findAll();

    public Supplier findById(int id);

    public Supplier save(Supplier supplier);

    public void deleteById(int id);
}