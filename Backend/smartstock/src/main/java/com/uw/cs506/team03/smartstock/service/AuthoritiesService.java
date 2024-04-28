package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Authorities;

import java.util.List;
import java.util.Optional;

/**
 * This interface is the service for the authorities table
 */
public interface AuthoritiesService {

    /**
     * This method is used to insert data into the authorities table
     * @param username the username of the user
     * @param authority the authority of the user
     */
    void insertData(String username, String authority);

    /**
     * This method is used to find all authorities
     * @return the list of authorities
     */
    public List<Authorities> findAll();

    /**
     * This method is used to find an authority by its username
     * @param username the username of the user
     * @return the authority
     */
    public Optional<Authorities> findByUsername(String username);

    /**
     * This method is used to save an authority
     * @param authorities the authority to save
     * @return the saved authority
     */
    public Authorities save(Authorities authorities);

    /**
     * This method is used to delete an authority by its username
     * @param username the username of the user
     */
    public void deleteByUsername(String username);

}
