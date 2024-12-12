package com.exemplio.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;
import com.exemplio.springboot.di.app.springbootdi.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Users> findAll() {
        return (List<Users>) repository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Users addUser(Users user) {
        return repository.save(user);
    }


}
