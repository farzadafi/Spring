package com.example.spring_unittest.repository;

import com.example.spring_unittest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
