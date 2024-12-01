package com.exemplio.springboot.di.app.springbootdi.services;

import java.util.List;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;

public interface UserService {
    
    List<Users> findAll();

    Users findById(Long id);

    Users addUser(Users user);
}