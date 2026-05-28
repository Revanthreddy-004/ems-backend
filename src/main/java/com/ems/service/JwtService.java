package com.ems.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey123456";

    public String generateToken(
            String username,
            String role
    ) {

        return Jwts.builder()

                .setSubject(username)

                .claim("role", role)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )

                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes()
                        )
                )

                .compact();
    }
}