package com.example.authentication_server.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtSecretKey {

    @Bean
    public SecretKey secretKey() {
        String SECRET_KEY =
                "YzMzN2UwY2JkY23NGYxNWFiNmVkNTczM44TBY2ZlZmQwNTk2ZDUyNG1RN9WQ0ZmU3ODhjOTBljUxMzIyYzg0Mg==";
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
