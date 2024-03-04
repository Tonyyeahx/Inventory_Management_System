package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.repository.NewTableRepository;
import com.uw.cs506.team03.smartstock.entity.NewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewTableServiceImp implements NewTableService{

    private NewTableRepository newTableRepository;

    @Autowired
    public NewTableServiceImp(NewTableRepository newTableRepository) {

        this.newTableRepository = newTableRepository;
    }

    @Override
    public void addUser(NewTable newTable) {
        newTableRepository.save(newTable);
    }

    @Override
    public void addStock(Integer id) {
        Optional<NewTable> result = newTableRepository.findById(id);
        NewTable tuple = null;
        if(result.isPresent()) {
            tuple = result.get();
        }
        else {
            throw new RuntimeException("can not find tuple by id: " + id);
        }
        int stock = tuple.getStock();
        int newStock = stock + 1;
        tuple.setStock(newStock);
    }

    @Override
    public void subStock(Integer id) {
        Optional<NewTable> result = newTableRepository.findById(id);
        NewTable tuple = null;
        if(result.isPresent()) {
            tuple = result.get();
        }
        else {
            throw new RuntimeException("can not find tuple by id: " + id);
        }
        int stock = tuple.getStock();
        int newStock = stock - 1;
        tuple.setStock(newStock);
    }

    @Override
    public NewTable sqlTesting() {
        return newTableRepository.sqlTesting();
    }

    @Override
    public NewTable save(NewTable newTable) {
        return newTableRepository.save(newTable);
    }

    @Override
    public NewTable findById(Integer id) {
        Optional<NewTable> result = newTableRepository.findById(id);
        NewTable tuple = null;
        if(result.isPresent()) {
            tuple = result.get();
        }
        else {
            throw new RuntimeException("can not find tuple by id: " + id);
        }
        return tuple;

    }

    @Override
    public void deleteById(Integer id) {
        newTableRepository.deleteById(id);
    }
}
