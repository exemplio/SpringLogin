package com.exemplio.springboot.di.app.springbootdi.repositories;

import com.exemplio.springboot.di.app.springbootdi.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
