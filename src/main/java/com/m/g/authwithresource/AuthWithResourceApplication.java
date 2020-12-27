package com.m.g.authwithresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthWithResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthWithResourceApplication.class, args);
    }

}
