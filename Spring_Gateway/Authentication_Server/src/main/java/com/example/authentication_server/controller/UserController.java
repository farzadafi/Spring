package com.example.authentication_server.controller;

import com.example.authentication_server.dto.UserDto;
import com.example.authentication_server.mapper.UserMapper;
import com.example.authentication_server.model.User;
import com.example.authentication_server.service.user.UserServiceImpel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userServiceImpel;

    public UserController(UserServiceImpel userServiceImpel) {
        this.userServiceImpel = userServiceImpel;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserDto userDto) {
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        userServiceImpel.registerUser(user);
        return "OK";
    }
}
