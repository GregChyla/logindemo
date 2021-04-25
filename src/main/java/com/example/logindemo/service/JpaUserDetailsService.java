package com.example.logindemo.service;

import com.example.logindemo.exception.UserAlreadyExistsException;
import com.example.logindemo.model.Role;
import com.example.logindemo.model.User;
import com.example.logindemo.model.UserCreateRequest;
import com.example.logindemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void createUser(@Valid UserCreateRequest userCreateRequest) {

        var userByUsername = userRepository.findUserByUsername(userCreateRequest.getUsername());
        userByUsername.ifPresentOrElse(user -> {
            throw new UserAlreadyExistsException("User [" + user.getUsername() + "] already exists");
        }, () -> {
            Set<Role> validatedRoles = RolesValidator.validate(userCreateRequest.getRoles());

            var user = User.builder()
                    .username(userCreateRequest.getUsername())
                    .email(userCreateRequest.getEmail())
                    .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                    .created(LocalDateTime.now())
                    .accountNonLocked(true)
                    .roles(validatedRoles)
                    .build();

            log.debug("Saving user: {}", user.toString());
            userRepository.saveAndFlush(user);
        });
    }
}
