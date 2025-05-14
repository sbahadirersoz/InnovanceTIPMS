package com.example.userservice.domain;

import com.example.userservice.insfructure.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class Validations
{
    private final JpaUserRepository repository;
    public Validations(JpaUserRepository repository)
    {
        this.repository = repository;
    }

}
