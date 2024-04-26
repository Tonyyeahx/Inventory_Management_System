package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the inventory table
 */
@RestController
public class InventoryController {
    InventoryService inventoryService;

    /**
     * This is the constructor for the InventoryController class
     * @param inventoryService the service for the inventory table
     */
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * This method is used to add a product to a store in the inventory
     * @param store the store id 
     * @param category the category name
     * @param supplier the supplier name
     * @return the list of products
     */
    @GetMapping("/filterInventories")
    public List<AllInOneDTO> findProductsByDynamicCriteria(@RequestParam(name = "store", required = false) Integer store, @RequestParam(name = "category", required = false) String category, @RequestParam(name = "category", required = false) String supplier) {
        //if param don't contain sellPrice then sellPrice will be null
        return  inventoryService.findProductsByDynamicCriteria(store, category, supplier);
    }

    /**
     * This method is used to get the inventory with the highest cost
     * @param inventoryId the id of the inventory
     * @param targetQuantity the target quantity
     * @return a string indicating the success of the operation
     */
    @PostMapping("/setInventoryQuantity")
    public String setInventoryQuantity(@RequestParam(name = "inventoryId", required = true) Integer inventoryId, @RequestParam(name = "targetQuantity", required = true) Integer targetQuantity) {
        return inventoryService.setInventoryQuantity(inventoryId, targetQuantity);
    }

    /**
     * This method is used to add a product to a store's inventory
     * @param inventoryId the id of the inventory
     * @param storeId the id of the store
     * @param productId the id of the product
     * @return a string indicating the success of the operation
     */
    @PostMapping("/deleteProductToAStoreFromInventory")
    public String deleteProductToAStoreFromInventory(@RequestParam(name = "inventoryId", required = true) Integer inventoryId, @RequestParam(name = "storeId", required = true) Integer storeId, @RequestParam(name = "productId", required = true) Integer productId) {
        inventoryService.deleteProductToAStoreFromInventory(inventoryId, storeId, productId);
        return "delete success";
    }

    //=======================CRUD APIs==============================================
    /**
     * This method is used to get all the tuples in the inventory table
     * @return a list of all the tuples in the inventory table
     */
    @GetMapping("/inventories")
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }
    
    /**
     * This method is used to get a specific tuple in the inventory table
     * @param id the id of the tuple to be retrieved
     * @return the tuple with the specified id
     */
    @GetMapping("/inventories/{id}")
    public Inventory findById(@PathVariable int id) {
        return inventoryService.findById(id);
    }
    
    /**
     * This method is used to add a tuple to the inventory table
     * @param inventory the tuple to be added
     * @return the tuple that was added
     */
    @PostMapping("inventories")
    public Inventory addTuple(@RequestBody Inventory inventory) {
        inventory.setInventoryId(0);
        Inventory theTuple = inventoryService.save(inventory);
        return  theTuple;
    }
    
    /**
     * This method is used to update a tuple in the inventory table
     * @param inventory the tuple to be updated
     * @return the updated tuple
     */
    @PutMapping("inventories")
    public Inventory updateTuple(@RequestBody Inventory inventory) {
        Inventory theTuple = inventoryService.save(inventory);
        return  theTuple;
    }
    
    /**
     * This method is used to delete a tuple in the inventory table
     * @param id the id of the tuple to be deleted
     * @return a string indicating whether the deletion was successful
     */
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
