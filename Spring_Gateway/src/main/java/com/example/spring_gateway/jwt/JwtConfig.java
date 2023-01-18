package com.example.spring_gateway.jwt;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtConfig {

    private final String secretKey =
            "YzMzN2UwY2JkY23NGYxNWFiNmVkNTczM44TBY2ZlZmQwNTk2ZDUyNG1RN9WQ0ZmU3ODhjOTBljUxMzIyYzg0Mg==";
    private final String tokenPrefix = "Bearer ";
}
