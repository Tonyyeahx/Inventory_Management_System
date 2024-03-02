package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.NewTable;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NewTableDAOImp implements NewTableDAO{

    private EntityManager entityManager;

    @Autowired
    //constructor injection
    public NewTableDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public NewTable save(NewTable newTable) {
        //if id == 0 merge will insert tuple to the DB
        //if id != 0 merge will update tuple to the DB
        NewTable updatedNewTable = entityManager.merge(newTable);
        return updatedNewTable;
    }

    @Override
    public  NewTable findById(Integer id) {
        return  entityManager.find(NewTable.class, id);
    }

    @Override
    public void deleteById(Integer id) {
        NewTable theNewTable = entityManager.find(NewTable.class, id);
        entityManager.remove(theNewTable);
    }

}
