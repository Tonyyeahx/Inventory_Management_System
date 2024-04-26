package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * This interface is the service for the inventory table
 */
public interface InventoryService {

    /**
     * This method is used to find a inventory by its id
     * @param InventoryId the id of the inventory 
     * @param storeId the id of the store
     * @param productId the id of the product
     * @param quantity the quantity of the product 
     * @param lastOrderDate the last order date of the product 
     * @param orderQuantity the order quantity of the product 
     * @param discount the discount of the product
     * @param sellPrice the sell price of the product
     */
    void addProductToInventory(int InventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice);
    
    /**
     * This method is used to delete a product from a store in the inventory
     * @param InventoryId the id of the inventory
     * @param storeId the id of the store
     * @param productId the id of the product
     */
    void deleteProductToAStoreFromInventory(int InventoryId, int storeId, int productId);

    /**
     * This method is used to find products by dynamic criteria
     * @param store the store id
     * @param category the category name
     * @param supplier the supplier name
     * @return the list of products
     */
    public List<AllInOneDTO> findProductsByDynamicCriteria(Integer store, String category, String supplier);

    /**
     * This method is used to set the inventory quantity
     * @param inventoryId the id of the inventory
     * @param targetQuantity the target quantity of the inventory
     * @return a message indicating the success of the operation
     */
    public String setInventoryQuantity(Integer inventoryId, Integer targetQuantity);

    /**
     * This method is used to find the highest cost inventory
     * @param storeId the id of the store
     * @return the inventory
     */
    public Inventory findHighestCostInventory(int storeId);

    //==================BASIC Functions are needed====================================
    /**
     * This method is used to find all the inventories
     * @return the list of inventories
     */
    public List<Inventory> findAll();

    /**
     * This method is used to find a inventory by its id
     * @param id the id of the inventory
     * @return the inventory
     */
    public Inventory findById(int id);

    /**
     * This method is used to save a inventory
     * @param inventory the inventory to be saved
     * @return the saved inventory
     */
    public Inventory save(Inventory inventory);

    /**
     * This method is used to delete a inventory by its id
     * @param id the id of the inventory
     */
    public void deleteById(int id);
    //==================================================================================



}