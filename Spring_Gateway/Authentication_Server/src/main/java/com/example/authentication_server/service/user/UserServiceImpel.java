package com.example.authentication_server.service.user;

import com.example.authentication_server.exception.UserNameDuplicateException;
import com.example.authentication_server.model.User;
import com.example.authentication_server.repository.UserRepository;

import java.util.Optional;

public class UserServiceImpel implements UserService{

    private final UserRepository repository;

    public UserServiceImpel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> findUser = repository.findByUsername(user.getUsername());
        if(findUser.isPresent())
            throw new UserNameDuplicateException(String.format("%s already defined", user.getUsername()));
        repository.save(user);
    }
}
