package com.bakhyzh.entplatform.auth.controller;

import com.bakhyzh.entplatform.auth.dto.AuthResponse;
import com.bakhyzh.entplatform.auth.dto.LoginRequest;
import com.bakhyzh.entplatform.auth.dto.RegisterRequest;
import com.bakhyzh.entplatform.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
