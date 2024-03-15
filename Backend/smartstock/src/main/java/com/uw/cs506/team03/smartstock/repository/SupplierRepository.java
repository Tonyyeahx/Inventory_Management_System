package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This interface is used to create sql searching methods for the Supplier object
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    Supplier findBySupplierId(int supplierId); // search by supplier id
}
