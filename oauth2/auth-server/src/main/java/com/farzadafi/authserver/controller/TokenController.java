package com.farzadafi.authserver.controller;

import com.farzadafi.authserver.dto.UserDto;
import com.farzadafi.authserver.jwt.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final Jwt jwt;

    public TokenController(Jwt jwt) {
        this.jwt = jwt;
    }

    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDto userDto) {
        String token = jwt.createToken(userDto.getUsername(), userDto.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
