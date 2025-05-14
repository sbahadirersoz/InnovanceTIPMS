package com.example.userservice.domain;


import com.example.userservice.domain.Events.UserAddRolesEvent;
import com.example.userservice.domain.Events.UserRegisteredEvent;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

public class UserClass implements Serializable {
    private UserId UserId;

    /*Unique*/
    private EmailClass email;
    private Set<Roles> roles = new HashSet<>(Set.of( Roles.USER));
    private String firstName;
    private String lastName;
    private Set<ProjectIds> projects = new HashSet<>();
    private Set<TaskId> tasks = new HashSet<>();
    private String hashedPWD;
    private final List<DomainEvent> domainEvents = new ArrayList<>();
    @CreationTimestamp
    @JsonFormat(pattern = "hh:mm/dd:MM:yyyy")
    private Date creationDate;


    public UserId getUserId() {
        return UserId;
    }

    public EmailClass getEmail() {
        return email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<ProjectIds> getProjects() {
        return projects;
    }

    public Set<TaskId> getTasks() {
        return tasks;
    }

    public String getHashedPWD() {
        return hashedPWD;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserClass() {
    }

    public UserClass(EmailClass email, String firstName, String lastName, String hashedPWD) {
        this.UserId= new UserId();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPWD = hashedPWD;
        Assert.notNull(email,ResponseMessages.NULL_RESPONSE.getMessage() + " email");
        Assert.notNull(firstName,ResponseMessages.NULL_RESPONSE.getMessage() + " FirstName");
        Assert.notNull(lastName,ResponseMessages.NULL_RESPONSE.getMessage() + " LastName");
    }
    public static UserClass register(EmailClass email, String firstName, String lastName, String hashedPWD)
    {
        UserClass user = new UserClass(email,firstName,lastName,hashedPWD);
        user.domainEvents.add(new UserRegisteredEvent( user.UserId,email,firstName,lastName,hashedPWD,user.creationDate));
        return user;
    }
    public boolean addRoles(List<Roles> roles)
    {
        roles.stream().map(x-> this.roles.add(x));
        this.domainEvents.add(new UserAddRolesEvent(this.roles,this.email));
        return  true;
    }
protected void registerEvent(DomainEvent event)
{
    domainEvents.add(event);

}
public List<DomainEvent>pullEvents()
{
    List<DomainEvent>list = new ArrayList<>(domainEvents);
    domainEvents.clear();
    return list;
}

}
