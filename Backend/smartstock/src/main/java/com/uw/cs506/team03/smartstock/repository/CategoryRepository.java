package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is the repository for the category table
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    /**
     * This method is used to find a category by its id
     * @param categoryId the id of the category
     * @return the category
     */
    Category findByCategoryId(int categoryId);
}
