package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the store table
 */
@Service
public class StoreServiceImp implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    /**
     * This is the default constructor for the StoreServiceImp class
     */
    public StoreServiceImp() {
    }

    /**
     * This method is used to find all the stores
     * @return the list of stores
     */
    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    /**
     * This method is used to find a store by its id
     * @param id the id of the store
     * @return the store
     * @throws RuntimeException if the store is not found
     */
    @Override
    public Store findById(int id) {
        Optional<Store> store = storeRepository.findById(id);
        if(store.isPresent()) {
            return store.get();
        }
        else {
            throw new RuntimeException("Do not find tuple id " + id);
        }
    }

    /**
     * This method is used to save a store
     * @param store the store to be saved
     * @return the saved store
     */
    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    /**
     * This method is used to delete a store by its id
     * @param id the id of the store
     */
    @Override
    public void deleteById(int id) {
        storeRepository.deleteById(id);
    }
}
