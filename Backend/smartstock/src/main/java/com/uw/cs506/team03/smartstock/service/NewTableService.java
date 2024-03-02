package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.NewTable;

public interface NewTableService {

    void addUser(NewTable newTable);

    void addStock(Integer id);

    void subStock(Integer id);

    NewTable save(NewTable newTable);

    NewTable findById(Integer id);

    void deleteById(Integer id);
}
