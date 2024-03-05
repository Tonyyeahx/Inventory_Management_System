package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByInventoryIdAndProductId(int inventoryId, int productId);
}