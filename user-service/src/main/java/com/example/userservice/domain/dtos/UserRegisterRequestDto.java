package com.example.userservice.domain.dtos;

import com.example.userservice.domain.EmailClass;

public record UserRegisterRequestDto
        (
                String firstName,
                String lastName,
                EmailClass emailClass,

                String password
        )
{

}
