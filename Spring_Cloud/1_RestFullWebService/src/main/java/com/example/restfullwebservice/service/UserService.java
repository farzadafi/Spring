package com.example.restfullwebservice.service;

import com.example.restfullwebservice.exception.UserNotFoundException;
import com.example.restfullwebservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserService {

    private static final List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "farzad", LocalDateTime.now().minusYears(26)));
        users.add(new User(++userCount, "farhad", LocalDateTime.now().minusYears(25)));
        users.add(new User(++userCount, "fardad", LocalDateTime.now().minusYears(24)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().
                filter(predicate)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("this user not found"));
    }

    public User addUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
