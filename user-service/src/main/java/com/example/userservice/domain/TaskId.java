package com.example.userservice.domain;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.UUID;

public record TaskId(UUID taskId) implements Serializable

{
    public TaskId
    {
        Assert.notNull(taskId,ResponseMessages.NULL_RESPONSE.getMessage());
    }

    public TaskId()
    {
        this(UUID.randomUUID());
    }
}
