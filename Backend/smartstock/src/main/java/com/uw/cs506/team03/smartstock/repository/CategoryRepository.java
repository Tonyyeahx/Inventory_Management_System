package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This interface is used to create sql searching methods for the Category object
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category findByCategoryId(int categoryId); // search by category id
}
