package com.example.restfullwebservice.service;

import com.example.restfullwebservice.exception.UserNotFoundException;
import com.example.restfullwebservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "farzad", LocalDateTime.now().minusYears(26)));
        users.add(new User(2, "farhad", LocalDateTime.now().minusYears(25)));
        users.add(new User(3, "fardad", LocalDateTime.now().minusYears(24)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        return users.stream().
                filter(user -> user
                        .getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("this user not found"));
    }
}
