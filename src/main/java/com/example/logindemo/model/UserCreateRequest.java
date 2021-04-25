package com.example.logindemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserCreateRequest {

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 40)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 40)
    private String password;

    List<String> roles;
}
