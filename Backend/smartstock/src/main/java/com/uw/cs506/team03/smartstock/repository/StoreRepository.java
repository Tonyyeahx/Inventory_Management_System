package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface is the repository for the store table
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    /**
     * This method is used to find a store by its id
     * @param storeId the id of the store
     * @return the store
     */
    @Query(value = "SELECT * FROM store", nativeQuery = true)
    List<Store> sqltest();

}
