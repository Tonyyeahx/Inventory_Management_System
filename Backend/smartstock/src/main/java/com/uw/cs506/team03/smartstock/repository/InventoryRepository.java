package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("SELECT new com.uw.cs506.team03.smartstock.dto.AllInOneDTO(" +
            "i.inventoryId, s.storeId, p.productId, p.productName, c.categoryId, c.categoryName, p.cost, i.sellPrice, i.quantity, i.discount, i.lastOrderDate, i.orderQuantity, sup.supplierId, sup.supplierName) " +
            "FROM Product p JOIN Inventory i ON p.productId = i.product.productId " +
            "JOIN Store s ON s.storeId = i.store.storeId " +
            "JOIN Supplier sup ON sup.supplierId = p.supplier.supplierId " +
            "JOIN Category c ON c.categoryId = p.category.categoryId " +
            "WHERE (:store IS NULL OR s.storeId = :store) AND " +
            "(:category IS NULL OR c.categoryName = :category) AND " +
            "(:sellPrice IS NULL OR sup.supplierName = :supplier)")
    List<AllInOneDTO> findProductsByDynamicCriteria(@Param("store") Integer store, @Param("category") String category, @Param("supplier") String supplier);


}