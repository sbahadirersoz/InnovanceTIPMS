package com.example.userservice.insfructure;

import com.example.userservice.domain.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserClassEntity {
    public UserClassEntity() {
    }

    @EmbeddedId
    private UserId UserId;

    /*Unique*/
    @Embedded
    private EmailClass email;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "UserId"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles = new HashSet<>();
    private String firstName;
    private String lastName;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_projects", joinColumns = @JoinColumn(name = "UserId"))


    private Set<ProjectIds> projects = new HashSet<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_tasks", joinColumns = @JoinColumn(name = "UserId"))

    private Set<TaskId> tasks = new HashSet<>();
    private String hashedPWD;
    @CreationTimestamp
    @JsonFormat(pattern = "hh:mm/dd:MM:yyyy")
    private Date creationDate;

    public UserClassEntity(UserClass userClass) {
        this.UserId = userClass.getUserId();
        this.creationDate = userClass.getCreationDate();
        this.hashedPWD = userClass.getHashedPWD();
        this.email = userClass.getEmail();
        this.firstName = userClass.getFirstName();
        this.lastName = userClass.getLastName();
        this.projects = userClass.getProjects();
        this.tasks = userClass.getTasks();
        this.roles = userClass.getRoles();
    }

    public static UserClassEntity classToEntity(UserClass userClass)
    {
        return new UserClassEntity(userClass.getUserId(), userClass.getEmail(),
                userClass.getRoles(), userClass.getFirstName(),
                userClass.getLastName(), userClass.getProjects(),
                userClass.getTasks(), userClass.getHashedPWD(),
                userClass.getCreationDate());
    }

    public UserClassEntity(UserId userId, EmailClass email, Set<Roles> roles, String firstName, String lastName, Set<ProjectIds> projects, Set<TaskId> tasks, String hashedPWD, Date creationDate) {
        UserId = userId;
        this.email = email;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projects = projects;
        this.tasks = tasks;
        this.hashedPWD = hashedPWD;
        this.creationDate = creationDate;
    }
}
