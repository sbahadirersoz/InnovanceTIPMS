package com.example.userservice.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import org.springframework.util.Assert;
@Embeddable

public record EmailClass


        (

                @Pattern(
                        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
                        message = "Invalid email format"
                )
                String value
        )
{
    public EmailClass
    {
        Assert.notNull(value,ResponseMessages.NULL_RESPONSE.getMessage()+" Email");
    }
}
