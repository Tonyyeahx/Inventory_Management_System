package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.Store;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAOImp implements StoreDAO{
    private EntityManager entityManager;

    @Autowired
    public StoreDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Store save(Store store) {
        Store updatedTuple = entityManager.merge(store);
        return updatedTuple;
    }

    @Override
    public Store findById(Integer id) {
        return entityManager.find(Store.class, id);
    }

    @Override
    public void deleteById(Integer id) {
        Store theTuple = entityManager.find(Store.class, id);
        entityManager.remove(theTuple);
    }

}
