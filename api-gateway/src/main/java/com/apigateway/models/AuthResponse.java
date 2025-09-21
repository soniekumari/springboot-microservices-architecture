package com.apigateway.models;

import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expireAt;

    private Collection<String> authorities;
}
