package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.NewTable;

public interface NewTableDAO {

    NewTable save(NewTable newTable);

    NewTable findById(Integer id);

    void deleteById(Integer id);

}
