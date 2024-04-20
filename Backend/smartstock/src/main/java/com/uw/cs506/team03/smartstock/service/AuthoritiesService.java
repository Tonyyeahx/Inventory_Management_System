package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Authorities;

import java.util.List;
import java.util.Optional;

public interface AuthoritiesService {

    public List<Authorities> findAll();

    public Optional<Authorities> findByUsername(String username);

    public Authorities save(Authorities authorities);

    public void deleteByUsername(String username);

}
