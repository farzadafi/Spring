package com.example.spring_unittest.service.user;

import com.example.spring_unittest.model.User;

import java.util.Optional;

public interface UserService {
    void register(User user);
    Optional<User> findById(Integer id);
    Optional<User> findByUsername(String username);
}
