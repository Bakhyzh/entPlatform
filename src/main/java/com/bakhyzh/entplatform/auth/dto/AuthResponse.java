package com.bakhyzh.entplatform.auth.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthResponse {

    String accessToken;
    String tokenType;
}
