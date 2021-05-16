package com.example.logindemo.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class UserCreatedResponse {
    private final Long id;
    private final String username;
    private final String email;
}
