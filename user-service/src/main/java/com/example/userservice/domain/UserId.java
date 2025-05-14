package com.example.userservice.domain;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.UUID;

@Embeddable
public record UserId
(
        UUID uuid
) {
    public UserId {
        Assert.notNull(uuid, ResponseMessages.NULL_RESPONSE.getMessage());
    }

    public UserId() {
        this(UUID.randomUUID());
    }
}
