package com.bakhyzh.entplatform.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // public
                        .requestMatchers(
                                "/api/v1/auth/**",
                                "/api/v1/users/register"
                        ).permitAll()

                        // teacher/admin only
                        .requestMatchers("/api/v1/questions/**")
                        .hasAnyRole("TEACHER", "ADMIN")

                        // student/admin
                        .requestMatchers("/api/v1/tests/**")
                        .hasAnyRole("STUDENT", "ADMIN")

                        // all authenticated
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}