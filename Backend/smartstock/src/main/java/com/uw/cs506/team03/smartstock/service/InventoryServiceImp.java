package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.repository.*;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the inventory table
 */
@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * This method is used to add a product to a store in the inventory
     */
    @Override
    public void addProductToInventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        Inventory product = new Inventory(inventoryId, storeId, productId, quantity, lastOrderDate, orderQuantity, discount, sellPrice);
        inventoryRepository.save(product);
    }

    /**
     * This method is used to delete a product from a store in the inventory
     */
    @Override
    public void deleteProductToAStoreFromInventory(int inventoryId, int storeId, int productId) {
        Inventory product = inventoryRepository.findByStoreIdAndProductId(storeId, productId);
        inventoryRepository.delete(product);
    }

    /**
     * This method is used to find products by dynamic criteria
     * @param store the store id
     * @param category the category name
     * @param supplier the supplier name
     * @return the list of products
     */
    @Override
    public List<AllInOneDTO> findProductsByDynamicCriteria(Integer store, String category, String supplier) {
        return inventoryRepository.findProductsByDynamicCriteria(store, category, supplier);
    }

    /**
     * This method is used to set the inventory quantity
     * @param inventoryId the id of the inventory
     * @param targetQuantity the target quantity
     * @return the message
     * @throws RuntimeException if the tuple is not found
     */
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

    /**
     * This method is used to find the highest cost inventory
     * @param storeId the store id
     * @return the inventory
     */
    public Inventory findHighestCostInventory(int storeId) {
        List<Inventory> inventories = inventoryRepository.findHighestCostByStoreId(storeId);
        if(inventories.isEmpty()) {
            return null;
        }
        return inventories.get(0);
    }

    //==============================BASIC CRUD===================================

    /**
     * This method is used to find all the inventories
     * @return the list of inventories
     */
    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    /**
     * This method is used to find a inventory by its id
     * @param id the id of the inventory
     * @return the inventory
     */
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

    /**
     * This method is used to save a inventory
     * @param inventory the inventory to be saved
     * @return the saved inventory
     */
    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * This method is used to delete a inventory by its id
     * @param id the id of the inventory
     */
    @Override
    public void deleteById(int id) {
        inventoryRepository.deleteById(id);
    }
    //==========================================================================

}