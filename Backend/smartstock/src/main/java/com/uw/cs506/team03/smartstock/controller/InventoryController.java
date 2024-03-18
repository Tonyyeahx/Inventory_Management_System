package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test2")
public class InventoryController {
    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/zzz")
    public List<AllInOneDTO> findProductsByDynamicCriteria(@RequestParam(name = "store", required = false) Integer store, @RequestParam(name = "category", required = false) String category, @RequestParam(name = "category", required = false) String supplier) {
        //if param don't contain sellPrice then sellPrice will be null
        return  inventoryService.findProductsByDynamicCriteria(store, category, supplier);
    }

    @PostMapping("/setInventoryQuantity")
    public String setInventoryQuantity(@RequestParam(name = "inventoryId", required = true) Integer inventoryId, @RequestParam(name = "targetQuantity", required = true) Integer targetQuantity) {
        return inventoryService.setInventoryQuantity(inventoryId, targetQuantity);
    }

}
