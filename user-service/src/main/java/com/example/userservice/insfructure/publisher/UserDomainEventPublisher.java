package com.example.userservice.insfructure.publisher;

import com.example.userservice.domain.DomainEvent;

import java.util.List;

public interface UserDomainEventPublisher
{
    void publish(List<DomainEvent> event);
}
