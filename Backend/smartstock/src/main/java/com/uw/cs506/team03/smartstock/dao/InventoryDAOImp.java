package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.Inventory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InventoryDAOImp implements InventoryDAO {

    private EntityManager entityManager;

    @Autowired
    //constructor injection
    public InventoryDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Inventory save(Inventory inventory) {
        //if id == 0 merge will insert tuple to the DB
        //if id != 0 merge will update tuple to the DB
        Inventory updatedInventory = entityManager.merge(inventory);
        return updatedInventory;
    }

    @Override
    public  Inventory findById(Integer id) {
        return  entityManager.find(Inventory.class, id);
    }

    @Override
    public void deleteById(Integer id) {
        Inventory theInventory = entityManager.find(Inventory.class, id);
        entityManager.remove(theInventory);
    }

    
}