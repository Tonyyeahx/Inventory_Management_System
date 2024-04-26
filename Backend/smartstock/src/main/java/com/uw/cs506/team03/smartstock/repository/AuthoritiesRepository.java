package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * This interface is the repository for the authorities table
 */
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

    @Modifying

    /**
     * This method is used to insert data into the authorities table
     * @param col1Value the username of the user
     * @param col2Value the authority of the user
     */
    @Query(value = "INSERT INTO authorities (username, authority) VALUES (:col1Value, :col2Value)", nativeQuery = true)
    void insertData(@Param("col1Value") String col1Value, @Param("col2Value") String col2Value);
}
