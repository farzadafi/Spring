package com.example.spring_security.controller;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.exception.FailSaveException;
import com.example.spring_security.mapper.UserMapper;
import com.example.spring_security.model.User;
import com.example.spring_security.service.user.UserServiceImpel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserServiceImpel userServiceImpel;

    public UserController(UserServiceImpel userServiceImpel) {
        this.userServiceImpel = userServiceImpel;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.dtoToModel(userDto);
        if (userServiceImpel.save(user).isPresent())
            return "OK";
        else
            throw new FailSaveException("Error save " + userDto.getUsername());
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/userWriteTest")
    public String userWriteTest() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities().toString();
    }

    @PreAuthorize("hasAnyAuthority('user:write','user:read')")
    @GetMapping("/userReadTest")
    public String userReadTest() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities().toString();
    }
}
