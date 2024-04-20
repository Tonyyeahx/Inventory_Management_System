package com.uw.cs506.team03.smartstock.repository;

import com.uw.cs506.team03.smartstock.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
