package com.bakhyzh.entplatform.user.controller;

import com.bakhyzh.entplatform.user.dto.RegisterRequest;
import com.bakhyzh.entplatform.user.dto.UserResponse;
import com.bakhyzh.entplatform.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}