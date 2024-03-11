package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProductToInventory(@RequestParam int inventoryId, 
                                                   @RequestParam int storeId, 
                                                   @RequestParam int productId, 
                                                   @RequestParam int quantity, 
                                                   @RequestParam Date lastOrderDate, 
                                                   @RequestParam int orderQuantity,
                                                   @RequestParam float discount,
                                                   @RequestParam float sellPrice
                                                   ) {
        inventoryService.addProductToInventory(inventoryId, storeId, productId, quantity, lastOrderDate, orderQuantity, discount, sellPrice);
        return ResponseEntity.ok("Product added to inventory successfully.");
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<?> removeProductFromInventory(@RequestParam int inventoryId, 
                                                        @RequestParam int productId) {
        inventoryService.removeProductFromInventory(inventoryId, productId);
        return ResponseEntity.ok("Product removed from inventory successfully.");
    }

    @PostMapping("/addQuantity")
    public ResponseEntity<?> addQuantityToInventory(@RequestParam int inventoryId, 
                                                    @RequestParam int productId, 
                                                    @RequestParam int quantity) {
        inventoryService.addQuantityToInventory(inventoryId, productId, quantity);
        return ResponseEntity.ok("Quantity added to inventory successfully.");
    }

    @PostMapping("/removeQuantity")
    public ResponseEntity<?> removeQuantityFromInventory(@RequestParam int inventoryId, 
                                                         @RequestParam int productId, 
                                                         @RequestParam int quantity) {
        inventoryService.removeQuantityFromInventory(inventoryId, productId, quantity);
        return ResponseEntity.ok("Quantity removed from inventory successfully.");
    }
}