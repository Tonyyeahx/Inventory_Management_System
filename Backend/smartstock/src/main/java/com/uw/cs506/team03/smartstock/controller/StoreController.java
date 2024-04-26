package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Store;

import com.uw.cs506.team03.smartstock.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the store table
 */
@RestController
public class StoreController {

    StoreService storeService;

    /**
     * This is the constructor for the StoreController class
     * @param storeService the service for the store table
     */
    @Autowired
    public  StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * This method is used to get all the tuples in the store table
     * @return a list of all the tuples in the store table
     */
    @GetMapping("/stores")
    public List<Store> findAll() {
        return storeService.findAll();
    }
    
    /**
     * This method is used to get a specific tuple in the store table
     * @param id the id of the tuple to be retrieved
     * @return the tuple with the specified id
     */
    @GetMapping("/stores/{id}")
    public Store findById(@PathVariable int id) {
        return storeService.findById(id);
    }
    
    /**
     * This method is used to add a tuple to the store table
     * @param store the tuple to be added
     * @return the tuple that was added
     */
    @PostMapping("stores")
    public Store addTuple(@RequestBody Store store) {
        store.setStoreId(0);
        Store theTuple = storeService.save(store);
        return  theTuple;
    }
    
    /**
     * This method is used to update a tuple in the store table
     * @param store the tuple to be updated
     * @return the tuple that was updated
     */
    @PutMapping("stores")
    public Store updateTuple(@RequestBody Store store) {
        Store theTuple = storeService.save(store);
        return theTuple;
    }
    
    /**
     * This method is used to delete a tuple in the store table
     * @param id the id of the tuple to be deleted
     * @return a string indicating the success of the operation
     */
    @DeleteMapping("stores/{id}")
    public String deleteTuple(@PathVariable int id) {
        Store theTuple = storeService.findById(id);
        if(theTuple == null) {
            throw new RuntimeException("can not find tuple id " + id);
        }
        storeService.deleteById(id);
        return "deleted tuple[id: " + id + "success";
    }
}
