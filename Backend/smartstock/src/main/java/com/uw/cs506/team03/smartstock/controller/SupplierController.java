package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.service.CategoryService;
import com.uw.cs506.team03.smartstock.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    SupplierService supplierService;

    @Autowired
    public  SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }
    //find one tuple in the inventory table by id
    @GetMapping("/suppliers/{id}")
    public Supplier findById(@PathVariable int id) {
        return supplierService.findById(id);
    }
    //add one tuple in the inventory table
    @PostMapping("suppliers")
    public Supplier addTuple(@RequestBody Supplier supplier) {
        supplier.setSupplierId(0);
        Supplier theTuple = supplierService.save(supplier);
        return  theTuple;
    }
    //update one tuple in the inventory table
    @PutMapping("suppliers")
    public Supplier updateTuple(@RequestBody Supplier supplier) {
        Supplier theTuple = supplierService.save(supplier);
        return  theTuple;
    }
    //delete one tuple in the inventory table
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
