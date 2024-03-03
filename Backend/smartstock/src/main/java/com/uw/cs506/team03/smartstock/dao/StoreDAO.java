package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.Store;

public interface StoreDAO {
    Store save(Store store);

    Store findById(Integer id);

    void deleteById(Integer id);

}
