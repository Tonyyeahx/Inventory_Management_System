package com.uw.cs506.team03.smartstock.service;

import java.util.Date;

// This interface is used to define the methods that will be used to interact with the Inventory table in the database
public interface InventoryService {

    void addProductToInventory(int InventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity);
    void removeProductFromInventory(int InventoryId, int productId);
    void addQuantityToInventory(int InventoryId, int productId, int quantity);
    void removeQuantityFromInventory(int InventoryId, int productId, int quantity);

}