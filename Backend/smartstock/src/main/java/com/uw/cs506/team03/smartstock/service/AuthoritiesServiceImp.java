package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Authorities;
import com.uw.cs506.team03.smartstock.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthoritiesServiceImp implements AuthoritiesService{

    @Autowired
    private AuthoritiesRepository authoritiesRepository;


    @Override
    public List<Authorities> findAll() {
        return authoritiesRepository.findAll();
    }

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

    @Override
    public Authorities save(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    @Override
    public void deleteByUsername(String username) {
        authoritiesRepository.deleteById(username);
    }
}
