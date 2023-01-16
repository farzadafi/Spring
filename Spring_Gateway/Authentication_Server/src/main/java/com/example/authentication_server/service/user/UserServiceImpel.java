package com.example.authentication_server.service.user;

import com.example.authentication_server.exception.PasswordIncorrectException;
import com.example.authentication_server.exception.UserNameDuplicateException;
import com.example.authentication_server.exception.UserNotFoundException;
import com.example.authentication_server.model.User;
import com.example.authentication_server.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpel implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpel(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> findUser = repository.findByUsername(user.getUsername());
        if (findUser.isPresent())
            throw new UserNameDuplicateException(String.format("%s already defined", user.getUsername()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("%s not found!", username)));
    }

    @Override
    public boolean isLogin(String username, String password) {
        User user = findByUsername(username);
        boolean isLikePassword = passwordEncoder.matches(password, user.getPassword());
        if(isLikePassword)
            return true;
        else
            throw new PasswordIncorrectException("your password is Incorrect");
    }
}
