package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.Inventory;

public interface InventoryDAO {
    Inventory save(Inventory inventory);

    Inventory findById(Integer id);

    void deleteById(Integer id);

}