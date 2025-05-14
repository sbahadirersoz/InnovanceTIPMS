package com.example.userservice.application.Handler;

import com.example.userservice.domain.Events.UserAddRolesEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserAddRolesEventHandler {
    @EventListener
    public void handle(UserAddRolesEvent event)
    {

    }

}
