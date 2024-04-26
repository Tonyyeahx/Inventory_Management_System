package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import com.uw.cs506.team03.smartstock.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the supplier table
 */
@RestController
public class SupplierController {

    SupplierService supplierService;

    /**
     * This is the constructor for the SupplierController class
     * @param supplierService the service for the supplier table
     */
    @Autowired
    public  SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * This method is used to get all the tuples in the supplier table
     * @return a list of all the tuples in the supplier table
     */
    @GetMapping("/suppliers")
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }
    
    /**
     * This method is used to get a specific tuple in the supplier table
     * @param id
     * @return the tuple with the specified id
     */
    @GetMapping("/suppliers/{id}")
    public Supplier findById(@PathVariable int id) {
        return supplierService.findById(id);
    }
    
    /**
     * This method is used to add a tuple to the supplier table
     * @param supplier
     * @return the tuple that was added
     */
    @PostMapping("suppliers")
    public Supplier addTuple(@RequestBody Supplier supplier) {
        supplier.setSupplierId(0);
        Supplier theTuple = supplierService.save(supplier);
        return  theTuple;
    }
    
    /**
     * This method is used to update a tuple in the supplier table
     * @param supplier
     * @return the tuple that was updated
     */
    @PutMapping("suppliers")
    public Supplier updateTuple(@RequestBody Supplier supplier) {
        Supplier theTuple = supplierService.save(supplier);
        return  theTuple;
    }
    
    /**
     * This method is used to delete a tuple in the supplier table
     * @param id
     * @return a string indicating whether the deletion was successful
     */
    @DeleteMapping("suppliers/{id}")
    public String deleteTuple(@PathVariable int id) {
        Supplier theTuple = supplierService.findById(id);
        if(theTuple == null) {
            throw new RuntimeException("can not find tuple id " + id);
        }
        supplierService.deleteById(id);
        return "deleted tuple[id: " + id + "success";
    }
}
