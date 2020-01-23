package com.example.testcrudSpringBootMustache.repos;

import com.example.testcrudSpringBootMustache.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
