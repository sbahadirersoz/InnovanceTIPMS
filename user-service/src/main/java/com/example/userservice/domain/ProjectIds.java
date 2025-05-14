package com.example.userservice.domain;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.UUID;

public record ProjectIds
        (
                UUID projectId
        )

        implements Serializable
{
        public ProjectIds()
        {
                this(UUID.randomUUID());
        }public ProjectIds
        {
                Assert.notNull(projectId,ResponseMessages.NULL_RESPONSE.getMessage());
        }
}
