package com.exemplio.springboot.di.app.springbootdi.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/{id}")
    public Users show(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/users")
    public List<Users> getAllProducts() {
        List<Users> users = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setDni(resultSet.getInt("dni"));
                user.setNombre(resultSet.getString("nombre"));
                user.setApellido(resultSet.getString("apellido"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
