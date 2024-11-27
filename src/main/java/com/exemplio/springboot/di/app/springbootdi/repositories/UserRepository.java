package com.exemplio.springboot.di.app.springbootdi.repositories;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
