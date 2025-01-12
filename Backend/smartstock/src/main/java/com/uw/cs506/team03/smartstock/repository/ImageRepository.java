package com.uw.cs506.team03.smartstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uw.cs506.team03.smartstock.entity.Image;

/**
 * This interface is the repository for the image table
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    // Add any custom query methods if needed
}