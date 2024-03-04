package com.uw.cs506.team03.smartstock.dao;

import com.uw.cs506.team03.smartstock.entity.NewTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewTableRepository extends JpaRepository<NewTable, Integer> {
    // no need to write any code.

    @Query("SELECT n FROM NewTable n WHERE n.id = 1")
    NewTable sqlTesting();
}
