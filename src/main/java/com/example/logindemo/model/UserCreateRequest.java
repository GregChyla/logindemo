package com.example.logindemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties
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
}
