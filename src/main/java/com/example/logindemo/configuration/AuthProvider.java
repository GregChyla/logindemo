package com.example.logindemo.configuration;

import com.example.logindemo.model.User;
import com.example.logindemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        String encodedPassword = passwordEncoder.encode(password);

        Optional<User> userOptional = userRepository.findUserByUsername(authentication.getName());
        return userOptional
                .filter(user -> user.isEnabled() && user.isAccountNonExpired() && user.isAccountNonLocked() && user.isCredentialsNonExpired())
                .map(user -> {
                    if (user.getUsername().equals(username) && passwordEncoder.matches(password, encodedPassword)) {
                        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
                    } else {
                        throw new BadCredentialsException("Username or password mismatch");
                    }
                })
                .orElseThrow(() -> new BadCredentialsException("Username or password mismatch"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
