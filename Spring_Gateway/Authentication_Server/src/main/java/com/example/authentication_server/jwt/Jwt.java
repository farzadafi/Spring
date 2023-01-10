package com.example.authentication_server.jwt;

import com.example.authentication_server.service.user.UserServiceImpel;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;

@Component
public class Jwt {

    private final SecretKey secretKey;
    private final UserServiceImpel userServiceImpel;

    public Jwt(SecretKey secretKey, UserServiceImpel userServiceImpel) {
        this.secretKey = secretKey;
        this.userServiceImpel = userServiceImpel;
    }

    public String createToken(String username, String password) {
        if (userServiceImpel.isLogin(username, password)) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(14)))
                    .signWith(secretKey)
                    .compact();
        }
        return null;
    }
}
