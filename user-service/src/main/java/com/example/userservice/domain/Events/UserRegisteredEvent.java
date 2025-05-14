package com.example.userservice.domain.Events;

import com.example.userservice.domain.DomainEvent;
import com.example.userservice.domain.EmailClass;
import com.example.userservice.domain.UserId;

import java.util.Date;

public class UserRegisteredEvent extends DomainEvent {

    private final UserId userId;
    private final String lastName;
    private final String firstName;
    private final EmailClass emailClass;
    private final String hashedPWD;
    private final Date creationDate;
    public UserRegisteredEvent(UserId userId, EmailClass email, String firstName, String lastName, String hashedPWD, Date creationDate)
    {
        this.userId = userId;
        this.emailClass = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPWD = hashedPWD;
        this.creationDate = creationDate;
    }
    @Override
    public String toString() {
        return "UserRegisteredEvent{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailClass=" + emailClass +
                ", hashedPWD='" + hashedPWD + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public UserId getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmailClass getEmailClass() {
        return emailClass;
    }

    public String getHashedPWD() {
        return hashedPWD;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
