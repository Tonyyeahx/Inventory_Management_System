package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.dto.LoginDTO;
import com.uw.cs506.team03.smartstock.entity.Authorities;
import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.entity.Users;
import com.uw.cs506.team03.smartstock.service.AuthoritiesService;
import com.uw.cs506.team03.smartstock.service.StoreService;
import com.uw.cs506.team03.smartstock.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
public class LoginController {

    AuthoritiesService authoritiesService;
    UsersService usersService;
    StoreService storeService;


    @Autowired
    public LoginController(AuthoritiesService authoritiesService, UsersService usersService, StoreService storeService) {
        this.authoritiesService = authoritiesService;
        this.usersService = usersService;
        this.storeService = storeService;
    }

    @PostMapping("/login")
    public String addUser(@RequestBody LoginDTO loginDTO) {
        //check username
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        String encodedPassword = "{bcrypt}" + encoder.encode(password);
        Integer storeId = loginDTO.getStoreId();
        Optional<Users> user = usersService.findById(username);
        Users newUser;
        Authorities authorities;
        Authorities authorities1;
        Store store;
        Store newStore;
        if(user != null) {
            return "username already exit";
        }
        if(loginDTO.getRole().equals("ROLE_MANAGER")) {
            store = new Store();
            store.setStoreId(0);
            store.setLongitude(123);
            store.setLatitude(321);
            store.setContact("1234567890");
            store.setOpenDate(new Date());
            store.setManager(username);
            newStore = storeService.save(store);
            storeId = newStore.getStoreId();
            newUser = new Users(username, encodedPassword, 1, storeId);
            usersService.save(newUser);
            authoritiesService.insertData(username, "ROLE_EMPLOYEE");
            authoritiesService.insertData(username, "ROLE_MANAGER");
        }
        else if(loginDTO.getRole().equals("ROLE_EMPLOYEE")) {
            storeId = loginDTO.getStoreId();
            newUser = new Users(username, encodedPassword, 1, storeId);
            usersService.save(newUser);
            authorities = new Authorities(username, "ROLE_EMPLOYEE");
            authoritiesService.save(authorities);
        }
        else {
            return "WRONG_ROLE_SETTING";
        }
        return "add user success";
    }

    @GetMapping("/users/test/{id}")
    public String findUsersByName(@PathVariable String id) {
        Optional<Users> users = usersService.findById(id);
        if(users == null) return "X";
        return "O";
    }








}
