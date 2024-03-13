package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    Supplier findBySupplierId(int supplierId);
}
