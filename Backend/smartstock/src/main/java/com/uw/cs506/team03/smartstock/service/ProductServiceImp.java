package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.repository.*;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductServiceImp implements ProductService {
    @Autowired
    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;

    @Override
    public float totalProductCost(int productId, int inventoryId, float cost) {
        Inventory product = inventoryRepository.findByInventoryIdAndProductId(inventoryId, productId);
        Product item = productRepository.findByProductId(productId);
        return (float)(product.getQuantity() * item.getCost());
    }
    
}
