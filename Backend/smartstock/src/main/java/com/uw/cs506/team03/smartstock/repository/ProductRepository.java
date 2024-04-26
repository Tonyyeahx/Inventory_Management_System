package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is the repository for the product table
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    /**
     * This method is used to find a product by its id
     * @param productId the id of the product
     * @return the product
     */
    Product findByProductId(int productId);
}
