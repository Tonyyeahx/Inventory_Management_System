package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.repository.*;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void addProductToInventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity) {
        Inventory product = new Inventory(storeId, productId, quantity, lastOrderDate, orderQuantity);
        inventoryRepository.save(product);
    }

    @Override
    public void removeProductFromInventory(int inventoryId, int productId) {
        Inventory product = inventoryRepository.findByInventoryIdAndProductId(inventoryId, productId);
        if(product != null){
            inventoryRepository.delete(product);
        }
        else{
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void addQuantityToInventory(int inventoryId, int productId, int quantity) {
        Inventory product = inventoryRepository.findByInventoryIdAndProductId(inventoryId, productId);
        product.setQuantity(product.getQuantity() + quantity);
        inventoryRepository.save(product);
    }

    @Override
    public void removeQuantityFromInventory(int inventoryId, int productId, int quantity) {
        Inventory inventory = inventoryRepository.findByInventoryIdAndProductId(inventoryId, productId);
        if(inventory.getQuantity() - quantity < 0){
            inventory.setQuantity(0);
        }else{
            inventory.setQuantity(inventory.getQuantity() - quantity);
        }
        inventoryRepository.save(inventory);
    }

}