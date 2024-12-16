package com.exemplio.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;

public interface UserService {
    
    List<Users> findAll();

    Optional<Users> findById(Long id);

    Optional<Users> findByEmail(String email);

    ResponseEntity<String> checkCredentials(Users user);

    Users addUser(Users user);
}