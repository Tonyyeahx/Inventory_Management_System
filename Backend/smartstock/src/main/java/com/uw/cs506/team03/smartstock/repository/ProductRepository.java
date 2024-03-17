package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByProductId(int productId);
}
