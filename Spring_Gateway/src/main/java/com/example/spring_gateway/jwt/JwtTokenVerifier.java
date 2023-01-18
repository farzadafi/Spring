package com.example.spring_gateway.jwt;

import com.example.spring_gateway.exception.InvalidTokenException;
import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Objects;

@Component
public class JwtTokenVerifier {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtTokenVerifier(JwtConfig jwtConfig, SecretKey secretKey) {
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    public void tokenVerifier(ServerHttpRequest request) {
        String authorizationHeader = Objects.requireNonNull(request.getHeaders().get("Authorization")).get(0);

        if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
            throw new InvalidTokenException("token is not correct format");
        }
        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
        }catch (JwtException e) {
            throw new InvalidTokenException("token is Invalid");
        }
    }
}
