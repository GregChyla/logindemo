package com.example.logindemo.service;

import com.example.logindemo.model.User;
import com.example.logindemo.model.dto.UserCreatedResponse;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedMapper {
    public UserCreatedResponse fromUser(User user) {
        return UserCreatedResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
