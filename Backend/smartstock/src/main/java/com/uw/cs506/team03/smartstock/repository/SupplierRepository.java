package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is the repository for the supplier table
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    /**
     * This method is used to find a supplier by its id
     * @param supplierId the id of the supplier
     * @return the supplier
     */
    Supplier findBySupplierId(int supplierId);
}
