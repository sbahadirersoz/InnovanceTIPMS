package com.example.userservice.insfructure.publisher;

import com.example.userservice.domain.DomainEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public  class SpringUserDomainEventPublisher implements UserDomainEventPublisher
{
    private final ApplicationEventPublisher publisher;

    public SpringUserDomainEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events)
    {
        for (DomainEvent event:
              events
        )
        {
            publisher.publishEvent(event);

        }
    }
}
