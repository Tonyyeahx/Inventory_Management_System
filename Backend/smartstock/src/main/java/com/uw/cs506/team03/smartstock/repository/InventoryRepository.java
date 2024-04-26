package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface is the repository for the inventory table
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    /**
     * This method is used to find an inventory by its id
     * @param inventoryId the id of the inventory
     * @return the inventory
     */
    @Query("SELECT new com.uw.cs506.team03.smartstock.dto.AllInOneDTO(" +
            "i.inventoryId, s.storeId, p.productId, p.productName, c.categoryId, c.categoryName, p.cost, i.sellPrice, i.quantity, i.discount, i.lastOrderDate, i.orderQuantity, sup.supplierId, sup.supplierName) " +
            "FROM Product p JOIN Inventory i ON p.productId = i.product.productId " +
            "JOIN Store s ON s.storeId = i.store.storeId " +
            "JOIN Supplier sup ON sup.supplierId = p.supplier.supplierId " +
            "JOIN Category c ON c.categoryId = p.category.categoryId " +
            "WHERE (:store IS NULL OR s.storeId = :store) AND " +
            "(:category IS NULL OR c.categoryName = :category) AND " +
            "(:supplier IS NULL OR sup.supplierName = :supplier)")
    List<AllInOneDTO> findProductsByDynamicCriteria(@Param("store") Integer store, @Param("category") String category, @Param("supplier") String supplier);

    /**
     * This method is used to find an inventory by its id
     * @param inventoryId the id of the inventory
     * @return the inventory
     */
    @Query("SELECT i FROM Inventory i WHERE i.store.storeId = :storeId ORDER BY i.product.cost DESC")
    List<Inventory> findHighestCostByStoreId(@Param("storeId") int storeId);

    /**
     * This method is used to find an inventory by its id
     * @param inventoryId the id of the inventory
     * @return the inventory
     */
    @Query("SELECT i FROM Inventory i WHERE i.store.storeId = :storeId AND i.product.productId = :productId")
    Inventory findByStoreIdAndProductId(@Param("storeId") int storeId, @Param("productId") int productId);

}