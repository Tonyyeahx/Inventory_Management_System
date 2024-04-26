package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the supplier table
 */
@Service
public class SupplierServiceImp implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    /**
     * This method is used to find all the suppliers
     * @return the list of suppliers
     */
    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    /**
     * This method is used to find a supplier by its id
     * @param id the id of the supplier
     * @return the supplier
     * @throws RuntimeException if the supplier is not found
     */
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

    /**
     * This method is used to save a supplier
     * @param supplier the supplier to be saved
     * @return the saved supplier
     */
    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    /**
     * This method is used to delete a supplier by its id
     * @param id the id of the supplier
     */
    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }
}
