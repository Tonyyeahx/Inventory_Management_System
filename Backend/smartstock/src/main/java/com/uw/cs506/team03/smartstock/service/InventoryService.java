package com.uw.cs506.team03.smartstock.service;

import java.util.Date;

public interface InventoryService {

    void addProductToInventory(int InventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice);
    void removeProductFromInventory(int InventoryId, int productId);
    void addQuantityToInventory(int InventoryId, int productId, int quantity);
    void removeQuantityFromInventory(int InventoryId, int productId, int quantity);

}