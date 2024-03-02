package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dao.NewTableDAO;
import com.uw.cs506.team03.smartstock.entity.NewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewTableServiceImp implements NewTableService{

    private NewTableDAO newTableDAO;

    @Autowired
    public NewTableServiceImp(NewTableDAO newTableDAO) {
        this.newTableDAO = newTableDAO;
    }

    @Override
    @Transactional
    public void addUser(NewTable newTable) {
        newTableDAO.save(newTable);
    }

    @Override
    @Transactional
    public void addStock(Integer id) {
        NewTable tuple = newTableDAO.findById(id);
        int stock = tuple.getStock();
        int newStock = stock + 1;
        tuple.setStock(newStock);
    }

    @Override
    @Transactional
    public void subStock(Integer id) {
        NewTable tuple = newTableDAO.findById(id);
        int stock = tuple.getStock();
        int newStock = stock - 1;
        tuple.setStock(newStock);
    }
}
