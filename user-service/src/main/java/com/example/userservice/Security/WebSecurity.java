package com.example.userservice.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class WebSecurity
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception
    {
        security.csrf(AbstractHttpConfigurer::disable);
     security.authorizeHttpRequests(x-> x.anyRequest().permitAll());
     security.httpBasic(AbstractHttpConfigurer::disable);
        return security.build();
    }
}
