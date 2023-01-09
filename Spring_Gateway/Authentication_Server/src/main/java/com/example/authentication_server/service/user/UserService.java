package com.example.authentication_server.service.user;

import com.example.authentication_server.model.User;

public interface UserService {

    void registerUser(User user);

    User findByUsername(String username);

    boolean isLogin(String username, String password);
}
