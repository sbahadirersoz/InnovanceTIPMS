package com.example.userservice.application;

import com.example.userservice.domain.ResponseMessages;
import com.example.userservice.domain.UserClass;
import com.example.userservice.domain.dtos.UserRegisterRequestDto;
import com.example.userservice.domain.dtos.UserRegisterResponseDto;
import com.example.userservice.insfructure.JpaUserRepository;
import com.example.userservice.insfructure.UserClassEntity;
import com.example.userservice.insfructure.publisher.SpringUserDomainEventPublisher;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service

public class UserService {
    private final JpaUserRepository repository;
    private final ValidationFactory validationFactory;
    private final SpringUserDomainEventPublisher springUserEventPublisher;
    private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(JpaUserRepository repository, ValidationFactory validationFactory, SpringUserDomainEventPublisher springUserEventPublisher) {
        this.repository = repository;
        this.validationFactory = validationFactory;
        this.springUserEventPublisher = springUserEventPublisher;
    }

    @Transactional
    public UserRegisterResponseDto registerUser(UserRegisterRequestDto dto)
    {

        UserClass user = generateUserClassFromRequestDtoWithHashedPassword(dto);
        repository.save(UserClassEntity.classToEntity(user));
        springUserEventPublisher.publish(user.pullEvents());
        return UserRegisterResponseDto.objectToDto(user);
    }

    private static UserClass generateUserClassFromRequestDtoWithHashedPassword(UserRegisterRequestDto dto) {
        return UserClass.register(dto.emailClass(), dto.firstName(), dto.lastName(), bCryptPasswordEncoder.encode(dto.password()));
    }
}
