package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImp implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

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

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public void deleteById(int id) {
        storeRepository.deleteById(id);
    }
}
