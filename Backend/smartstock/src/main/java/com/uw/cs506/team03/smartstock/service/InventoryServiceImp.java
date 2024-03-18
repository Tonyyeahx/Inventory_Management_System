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
    public void addProductToInventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        Inventory product = new Inventory(storeId, productId, quantity, lastOrderDate, orderQuantity, discount, sellPrice);
        inventoryRepository.save(product);
    }

}