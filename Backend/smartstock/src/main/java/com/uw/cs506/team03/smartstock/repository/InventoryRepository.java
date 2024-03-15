package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
// This interface is used to create sql searching methods for the Inventory object
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByInventoryIdAndProductId(int inventoryId, int productId); // search by inventory id and product id
}