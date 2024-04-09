package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Store;

import com.uw.cs506.team03.smartstock.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    StoreService storeService;

    @Autowired
    public  StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public List<Store> findAll() {
        return storeService.findAll();
    }
    //find one tuple in the inventory table by id
    @GetMapping("/stores/{id}")
    public Store findById(@PathVariable int id) {
        return storeService.findById(id);
    }
    //add one tuple in the inventory table
    @PostMapping("stores")
    public Store addTuple(@RequestBody Store store) {
        store.setStoreId(0);
        Store theTuple = storeService.save(store);
        return  theTuple;
    }
    //update one tuple in the inventory table
    @PutMapping("stores")
    public Store updateTuple(@RequestBody Store store) {
        Store theTuple = storeService.save(store);
        return theTuple;
    }
    //delete one tuple in the inventory table
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
