package com.example.restfullwebservice.service;

import com.example.restfullwebservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "farzad",  LocalDateTime.now().minusYears(26)));
        users.add(new User(1, "farhad",  LocalDateTime.now().minusYears(25)));
        users.add(new User(1, "fardad",  LocalDateTime.now().minusYears(24)));
    }

    public List<User> findAll() {
        return users;
    }
}
