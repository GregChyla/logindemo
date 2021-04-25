package com.example.logindemo.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserCreatedResponse {
    private final String username;
    private final String email;
}
