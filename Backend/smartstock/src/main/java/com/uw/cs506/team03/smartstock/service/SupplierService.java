package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Category;
import com.uw.cs506.team03.smartstock.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> findAll();

    public Supplier findById(int id);

    public Supplier save(Supplier supplier);

    public void deleteById(int id);
}