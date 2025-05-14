package com.example.userservice.domain.dtos;

import com.example.userservice.domain.EmailClass;
import com.example.userservice.domain.Events.UserRegisteredEvent;
import com.example.userservice.domain.UserClass;

public record UserRegisterResponseDto
        (
                String firstName,
                String lastName,
                EmailClass emailClass,

                String password
        )
{
        public static UserRegisterResponseDto objectToDto(UserClass userClass)
        {
                return new UserRegisterResponseDto(userClass.getFirstName(), userClass.getLastName(),userClass.getEmail(), userClass.getHashedPWD());
        }
}
