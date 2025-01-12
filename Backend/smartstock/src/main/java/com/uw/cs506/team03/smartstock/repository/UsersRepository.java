package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is the repository for the users table
 */
public interface UsersRepository extends JpaRepository<Users, String> {
}
