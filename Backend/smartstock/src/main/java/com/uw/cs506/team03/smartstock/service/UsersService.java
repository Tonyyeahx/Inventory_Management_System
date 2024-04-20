package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    public List<Users> findAll();

    public Optional<Users> findById(String id);

    public Users save(Users users);

    public void deleteByUsername(String username);

}
