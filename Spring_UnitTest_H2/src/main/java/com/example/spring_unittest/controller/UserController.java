package com.example.spring_unittest.controller;

import com.example.spring_unittest.dto.UserDto;
import com.example.spring_unittest.exception.UserNotFoundException;
import com.example.spring_unittest.mapper.UserMapper;
import com.example.spring_unittest.model.User;
import com.example.spring_unittest.service.user.UserServiceImpel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userService;

    public UserController(UserServiceImpel userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        userService.register(user);
        return "OK";
    }

    @GetMapping("/findUser")
    public UserDto findUser(@RequestParam Integer id) {
        User user = userService.findById(id)
                .orElseThrow( () -> new UserNotFoundException(id.toString() + " not found"));
        return UserMapper.INSTANCE.modelToDto(user);
    }

    @GetMapping("/findUserByUsername")
    public UserDto findUserByUsername(@RequestParam String username) {
        User user =  userService.findByUsername(username)
                .orElseThrow( () -> new UserNotFoundException(String.format("%s not found", username)));
        return UserMapper.INSTANCE.modelToDto(user);
    }
}
