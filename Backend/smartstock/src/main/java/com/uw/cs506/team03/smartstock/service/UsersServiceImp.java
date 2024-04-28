package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Users;
import com.uw.cs506.team03.smartstock.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * This class is the service for the users table
 */
@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    private UsersRepository usersRepository;

    /**
     * This is the default constructor for the UsersServiceImp class
     */
    public UsersServiceImp() {
    }

    /**
     * This method is used to find all the users.
     * 
     * @return the list of users
     */
    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    /**
     * This method is used to find a user by its id.
     * 
     * @param id the id of the user
     * @return the user, if found; otherwise, null
     */
    @Override
    public Optional<Users> findById(String id) {
        Optional<Users> user = usersRepository.findById(id);
        if(user.isPresent()) {
            return Optional.of(user.get());
        }
        else {
            return null;
        }
    }

    /**
     * This method is used to save a user.
     * 
     * @param users the user to be saved
     * @return the saved user
     */
    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    /**
     * This method is used to delete a user by its username.
     * 
     * @param username the username of the user to be deleted
     */
    @Override
    public void deleteByUsername(String username) {
        usersRepository.deleteById(username);
    }
}
