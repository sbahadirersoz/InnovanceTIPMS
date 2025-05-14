package com.example.userservice.domain.Events;

import com.example.userservice.domain.DomainEvent;
import com.example.userservice.domain.EmailClass;
import com.example.userservice.domain.Roles;

import java.util.Set;

public class UserAddRolesEvent extends DomainEvent {

    private Set<Roles> roles;
    private EmailClass emailClass;

    public UserAddRolesEvent(Set<Roles> roles, EmailClass email) {
        super();
    }


}
