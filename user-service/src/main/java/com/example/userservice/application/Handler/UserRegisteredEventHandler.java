package com.example.userservice.application.Handler;

import com.example.userservice.domain.Events.UserRegisteredEvent;
import com.example.userservice.domain.ResponseMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class UserRegisteredEventHandler {


    @EventListener
    public void handle(UserRegisteredEvent event) {
                log.info(ResponseMessages.CREATED_SUCCESFULY_RESPONSE.getMessage());

        System.out.println(event.getFirstName());
    }
}
