package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

// This interface is used to define the methods that will be used to interact with the Inventory table in the database
public interface InventoryService {

    void addProductToInventory(int InventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice);

    public List<AllInOneDTO> findProductsByDynamicCriteria(Integer store, String category, String supplier);

    public String setInventoryQuantity(Integer inventoryId, Integer targetQuantity);

}