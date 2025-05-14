package com.example.userservice.insfructure;

import com.example.userservice.domain.EmailClass;
import com.example.userservice.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserClassEntity,UserId>
{
    @Override
    Optional<UserClassEntity> findById(UserId userId);
    boolean existsUserClassEntitiesByEmail(EmailClass email);
}
