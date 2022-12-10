package com.example.spring_unittest.service.user;

import com.example.spring_unittest.exception.SaveFailException;
import com.example.spring_unittest.model.User;
import com.example.spring_unittest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpel implements UserService{

    private final UserRepository repository;

    public UserServiceImpel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        if(repository.save(user).getId() == null)
            throw new SaveFailException(String.format("fail to save %s", user.getUsername()));
    }
}
