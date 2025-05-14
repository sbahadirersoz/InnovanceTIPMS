package com.example.userservice.application;

import com.example.userservice.Exceptions.UserAlreadyExistException;
import com.example.userservice.domain.EmailClass;
import com.example.userservice.domain.ResponseMessages;
import com.example.userservice.domain.dtos.UserRegisterRequestDto;
import com.example.userservice.insfructure.JpaUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidationFactory 
{
/*Validations
* Exists
* Is Empty
* */
    private final JpaUserRepository repository;

    public ValidationFactory(JpaUserRepository repository) {
        this.repository = repository;
    }
    protected   boolean userExistByEmail(UserRegisterRequestDto dto)
    {
        if (repository.existsUserClassEntitiesByEmail(dto.emailClass())) {
        log.info(ResponseMessages.NOT_EXIST.getMessage() +dto.emailClass().value());
        }
        throw new UserAlreadyExistException(ResponseMessages.ALREADY_EXIST_RESPONSE.getMessage());
    }






}
