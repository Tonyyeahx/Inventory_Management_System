package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.repository.*;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void addProductToInventory(int inventoryId, int storeId, int productId, int quantity, Date lastOrderDate, int orderQuantity, float discount, float sellPrice) {
        Inventory product = new Inventory(storeId, productId, quantity, lastOrderDate, orderQuantity, discount, sellPrice);
        inventoryRepository.save(product);
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


}