package com.example.authservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{

    @Bean
    public SecurityFilterChain chain(HttpSecurity security) throws  Exception
    {
      return    security.build();
    }
}
