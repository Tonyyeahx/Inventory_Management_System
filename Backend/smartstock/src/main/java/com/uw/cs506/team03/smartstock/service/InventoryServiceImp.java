package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.repository.*;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    //add a product to a store in the inventory
    @Override
    public void addProductToInventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        Inventory product = new Inventory(inventoryId, storeId, productId, quantity, lastOrderDate, orderQuantity, discount, sellPrice);
        inventoryRepository.save(product);
    }

    //delete a product from a store in the inventory
    @Override
    public void deleteProductToAStoreFromInventory(int inventoryId, int storeId, int productId) {
        Inventory product = inventoryRepository.findByStoreIdAndProductId(storeId, productId);
        inventoryRepository.delete(product);
    }

    @Override
    public List<AllInOneDTO> findProductsByDynamicCriteria(Integer store, String category, String supplier) {
        return inventoryRepository.findProductsByDynamicCriteria(store, category, supplier);
    }

    @Override
    public String setInventoryQuantity(Integer inventoryId, Integer targetQuantity) {
        if(targetQuantity <= 0) return "\"msg\": \"Illegal targetQuantity input\"";
        Optional<Inventory> result = inventoryRepository.findById(inventoryId);
        Inventory tuple = null;
        if(result.isPresent()) {
            tuple = result.get();
        }
        else {
            throw new RuntimeException("can not find tuple by id: " + inventoryId);
        }
        System.out.println(inventoryId);
        System.out.println(targetQuantity);

        tuple.setQuantity(targetQuantity);
        inventoryRepository.save(tuple);
        return "\"msg\": \"Target quantity set successful\"";
    }
    //==============================BASIC CRUD===================================
    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory findById(int id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()) {
            return inventory.get();
        }
        else {
            throw new RuntimeException("Do not find tuple id " + id);
        }
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteById(int id) {
        inventoryRepository.deleteById(id);
    }
    //==========================================================================

}