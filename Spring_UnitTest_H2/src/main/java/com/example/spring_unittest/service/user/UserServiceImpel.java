package com.example.spring_unittest.service.user;

import com.example.spring_unittest.exception.UsernameDuplicateException;
import com.example.spring_unittest.model.User;
import com.example.spring_unittest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpel implements UserService {

    private final UserRepository repository;

    public UserServiceImpel(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        if(repository.findByUsername(user.getUsername()).isPresent())
            throw new UsernameDuplicateException(String.format("%s username is exist", user.getUsername() ));
        repository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
