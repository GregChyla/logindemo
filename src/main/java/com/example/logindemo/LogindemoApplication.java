package com.example.logindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled=true)
public class LogindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogindemoApplication.class, args);
    }

}
