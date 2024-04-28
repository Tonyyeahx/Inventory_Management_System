package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.service.StoreService;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the financial metrics
 */
@RestController
public class FinancialMetricController {

    @Autowired
    StoreService storeService;

    @Autowired
    InventoryService inventoryService;

    /**
     * This is the default constructor for the FinancialMetricController class
     */
    public FinancialMetricController(){
    }

    /**
     * This method is used to get the store with the highest revenue
     * @param storeId the id of the store
     * @return the store id
     */
    @GetMapping("/greatestCost/{storeId}")  // Fix the path variable name here to match the method parameter
    public int getGreatestCost(@PathVariable int storeId) {
        Inventory inventory = inventoryService.findHighestCostInventory(storeId);
        if(inventory != null) {
            return inventory.getInventoryId();
        }
        return -1; // Returning -1 if no inventory matches
    }
    
}
