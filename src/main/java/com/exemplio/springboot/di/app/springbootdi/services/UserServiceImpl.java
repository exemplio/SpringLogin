package com.exemplio.springboot.di.app.springbootdi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;
import com.exemplio.springboot.di.app.springbootdi.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return repository.getOne(id);
    }



}
