package com.bakhyzh.entplatform.auth.service;

import com.bakhyzh.entplatform.auth.dto.AuthResponse;
import com.bakhyzh.entplatform.auth.dto.LoginRequest;
import com.bakhyzh.entplatform.auth.dto.RegisterRequest;
import com.bakhyzh.entplatform.auth.exception.EmailAlreadyExistsException;
import com.bakhyzh.entplatform.auth.exception.InvalidCredentialsException;
import com.bakhyzh.entplatform.security.JwtService;
import com.bakhyzh.entplatform.user.entity.Role;
import com.bakhyzh.entplatform.user.entity.User;
import com.bakhyzh.entplatform.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return buildAuthResponse(user.getEmail());
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return buildAuthResponse(user.getEmail());
    }

    private AuthResponse buildAuthResponse(String email) {
        return AuthResponse.builder()
                .accessToken(jwtService.generateToken(email))
                .tokenType("Bearer")
                .build();
    }
}
