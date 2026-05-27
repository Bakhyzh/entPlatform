package com.bakhyzh.entplatform.user.dto;

import com.bakhyzh.entplatform.user.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String email;
    private Role role;
}