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
    public NewTableDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(NewTable newTable) {
        entityManager.persist(newTable);
    }

    @Override
    public  NewTable findById(Integer id) {
        return  entityManager.find(NewTable.class, id);
    }

    @Override
    public void update(NewTable newTable) {
        entityManager.merge(newTable);
    }
}
