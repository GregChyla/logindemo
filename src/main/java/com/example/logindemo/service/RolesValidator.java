package com.example.logindemo.service;

import com.example.logindemo.model.Role;
import com.example.logindemo.model.RolesEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class RolesValidator {
    public static Set<Role> validate(List<String> roles) {

        Set<Role> validatedRoles = new HashSet<>();

        if (Objects.isNull(roles) || roles.isEmpty()) {
            Role role = new Role();
            role.setRoleName(RolesEnum.ROLE_USER.getName());
            validatedRoles.add(role);
            return validatedRoles;
        }

        for (RolesEnum role: RolesEnum.values()) {
            if (roles.contains(role.getName())) {
                validatedRoles.add(new Role(role.getName()));
            }
        }
        if (validatedRoles.isEmpty()) {
            validatedRoles.add(new Role(RolesEnum.ROLE_USER.getName()));
        }

        return validatedRoles;
    }
}
