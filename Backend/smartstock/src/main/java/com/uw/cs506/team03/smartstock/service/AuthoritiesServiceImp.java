package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Authorities;
import com.uw.cs506.team03.smartstock.repository.AuthoritiesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the authorities table
 */
@Service
public class AuthoritiesServiceImp implements AuthoritiesService{

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    /**
     * This method is used to insert data into the authorities table
     * @param username the username of the user
     * @param authority the authority of the user
     */
    @Override
    @Transactional
    public void insertData(String username, String authority) {
        authoritiesRepository.insertData(username, authority);
    }

    /**
     * This method is used to find all the authorities
     * @return the list of authorities
     */
    @Override
    public List<Authorities> findAll() {
        return authoritiesRepository.findAll();
    }

    /**
     * This method is used to find an authority by its username
     * @param username the username of the user
     * @return the authority
     * @throws RuntimeException if the authority is not found
     */
    @Override
    public Optional<Authorities> findByUsername(String username) {
        Optional<Authorities> result = authoritiesRepository.findById(username);
        if(result.isPresent()) {
            return Optional.of(result.get());
        }
        else {
            throw new RuntimeException("Do not find tuple id " + username);
        }
    }

    /**
     * This method is used to save an authority
     * @param authorities the authority to be saved
     * @return the saved authority
     */
    @Override
    public Authorities save(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    /**
     * This method is used to delete an authority by its username
     * @param username the username of the user
     */
    @Override
    public void deleteByUsername(String username) {
        authoritiesRepository.deleteById(username);
    }
}
