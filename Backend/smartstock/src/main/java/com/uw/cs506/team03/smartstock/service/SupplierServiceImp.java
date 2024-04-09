package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(int id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isPresent()) {
            return supplier.get();
        }
        else {
            throw new RuntimeException("Do not find tuple id " + id);
        }
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }
}
