package com.example.spring_security.service.user;


import com.example.spring_security.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> save(User user);
}
