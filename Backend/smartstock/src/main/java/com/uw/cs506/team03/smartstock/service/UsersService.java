package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Users;

import java.util.List;
import java.util.Optional;

/**
 * This interface is the service for the users table
 */
public interface UsersService {

    /**
     * This method is used to find all users
     * @return the list of users
     */
    public List<Users> findAll();

    /**
     * This method is used to find a user by its id
     * @param id the id of the user
     * @return the user
     */
    public Optional<Users> findById(String id);

    /**
     * This method is used to find a user by its username
     * @param username the username of the user
     * @return the user
     */
    public Users save(Users users);

    /**
     * This method is used to delete a user by its id
     * @param id the id of the user
     */
    public void deleteByUsername(String username);

}
