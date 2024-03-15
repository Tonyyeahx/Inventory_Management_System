package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// This interface is used to create sql searching methods for the Store object
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query(value = "SELECT * FROM store", nativeQuery = true)
    List<Store> sqltest();

}
