package com.exemplio.springboot.di.app.springbootdi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;
import com.exemplio.springboot.di.app.springbootdi.services.UserService;

@RestController
@RequestMapping("/api")
public class SomeController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public List<Users> list() {
        return service.findAll();
    }

    @PostMapping("/sign_in")
    public ResponseEntity<Users> sessionLogin(@RequestBody Users user){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Users> addUsers(@RequestBody Users user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addUser(user));
    }
    
//    @GetMapping("/{id}")
//    public Users show(@PathVariable Long id) {
//        return service.findById(id);
//    }

}
