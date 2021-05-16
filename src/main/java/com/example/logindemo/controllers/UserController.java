package com.example.logindemo.controllers;

import com.example.logindemo.model.UserCreateRequest;
import com.example.logindemo.model.dto.UserCreatedResponse;
import com.example.logindemo.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JpaUserDetailsService userDetailsService;

    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("USER");
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("ADMIN");
    }

    @GetMapping("/any")
    public ResponseEntity<String> any() {
        return ResponseEntity.ok("ANY");
    }

    @PostMapping("/register")
    public ResponseEntity<UserCreatedResponse> addUser(@RequestBody UserCreateRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userDetailsService.createUser(body));
    }
}
