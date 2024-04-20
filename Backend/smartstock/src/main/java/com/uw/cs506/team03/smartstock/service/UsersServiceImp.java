package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Users;
import com.uw.cs506.team03.smartstock.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    private UsersRepository usersRepository;




    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

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

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void deleteByUsername(String username) {
        usersRepository.deleteById(username);
    }
}
