package com.example.authentication_server.controller;

import com.example.authentication_server.dto.UserDto;
import com.example.authentication_server.jwt.Jwt;
import com.example.authentication_server.mapper.UserMapper;
import com.example.authentication_server.model.User;
import com.example.authentication_server.service.user.UserServiceImpel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userServiceImpel;
    private final Jwt jwt;

    public UserController(UserServiceImpel userServiceImpel, Jwt jwt) {
        this.userServiceImpel = userServiceImpel;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserDto userDto) {
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        userServiceImpel.registerUser(user);
        return "OK";
    }

    @GetMapping("/getToken/{username}/{password}")
    public String getToken(@PathVariable String username, @PathVariable String password) {
        return jwt.createToken(username, password);
    }
}
