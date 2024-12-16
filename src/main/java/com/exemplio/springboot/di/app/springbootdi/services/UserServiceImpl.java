package com.exemplio.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        repository.findByEmail(user.getEmail())
                .ifPresent(existingUser -> {
                    throw new RuntimeException("User already exists");
                });
        return repository.save(user);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public ResponseEntity<String> checkCredentials(Users user) {
        Optional<Users> existingUserOpt = repository.findByEmail(user.getEmail());
        return existingUserOpt.map(existingUser -> {
            if (user.getPassword().equals(existingUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body("¡Credenciales válidas!"); // 200 OK
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("NO COINCIDE");
            }
        }).orElse(ResponseEntity.status(HttpStatus.OK)
                .body("Usuario no encontrado"));
    }

}
