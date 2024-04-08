package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/filterInventories")
    public List<AllInOneDTO> findProductsByDynamicCriteria(@RequestParam(name = "store", required = false) Integer store, @RequestParam(name = "category", required = false) String category, @RequestParam(name = "category", required = false) String supplier) {
        //if param don't contain sellPrice then sellPrice will be null
        return  inventoryService.findProductsByDynamicCriteria(store, category, supplier);
    }

    @PostMapping("/setInventoryQuantity")
    public String setInventoryQuantity(@RequestParam(name = "inventoryId", required = true) Integer inventoryId, @RequestParam(name = "targetQuantity", required = true) Integer targetQuantity) {
        return inventoryService.setInventoryQuantity(inventoryId, targetQuantity);
    }

    //API for deleting a product from a store in the inventory
    @PostMapping("/deleteProductToAStoreFromInventory")
    public String deleteProductToAStoreFromInventory(@RequestParam(name = "inventoryId", required = true) Integer inventoryId, @RequestParam(name = "storeId", required = true) Integer storeId, @RequestParam(name = "productId", required = true) Integer productId) {
        inventoryService.deleteProductToAStoreFromInventory(inventoryId, storeId, productId);
        return "delete success";
    }

    //=======================CRUD APIs==============================================
    //find all tuple in the inventory table
    @GetMapping("/inventories")
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }
    //find one tuple in the inventory table by id
    @GetMapping("/inventories/{id}")
    public Inventory findById(@PathVariable int id) {
        return inventoryService.findById(id);
    }
    //add one tuple in the inventory table
    @PostMapping("inventories")
    public Inventory addTuple(@RequestBody Inventory inventory) {
        inventory.setInventoryId(0);
        Inventory theTuple = inventoryService.save(inventory);
        return  theTuple;
    }
    //update one tuple in the inventory table
    @PutMapping("inventories")
    public Inventory updateTuple(@RequestBody Inventory inventory) {
        Inventory theTuple = inventoryService.save(inventory);
        return  theTuple;
    }
    //delete one tuple in the inventory table
    @DeleteMapping("inventories/{id}")
    public String deleteTuple(@PathVariable int id) {
        Inventory theTuple = inventoryService.findById(id);
        if(theTuple == null) {
            throw new RuntimeException("can not find tuple id " + id);
        }
        inventoryService.deleteById(id);
        return "deleted tuple[id: " + id + "success";
    }
    //=======================================================================
}
