package com.ems.controller;

import com.ems.entity.User;
import com.ems.repository.UserRepository;
import com.ems.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow();

        if (
                existingUser.getPassword()
                        .equals(user.getPassword())
        ) {

            return jwtService.generateToken(
                    existingUser.getUsername(),
                    existingUser.getRole()
            );
        }

        return "Invalid Credentials";
    }
}