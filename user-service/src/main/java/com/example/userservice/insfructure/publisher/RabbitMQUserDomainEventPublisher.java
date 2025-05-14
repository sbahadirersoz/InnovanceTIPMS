package com.example.userservice.insfructure.publisher;

import com.example.userservice.domain.DomainEvent;
import com.example.userservice.domain.Events.UserRegisteredEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class RabbitMQUserDomainEventPublisher implements UserDomainEventPublisher {


    private final RabbitTemplate template;

    public RabbitMQUserDomainEventPublisher(RabbitTemplate template) {
        this.template = template;
    }
/*RabbitMQ Que tanımla */
    @Override
    public void publish(List<DomainEvent> events)
    {
        for (DomainEvent event : events )
        {
            if (event instanceof UserRegisteredEvent e)
            {
                template.convertAndSend("user_exchance");
            }
        }
    }
}
