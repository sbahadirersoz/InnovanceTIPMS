package com.example.userservice.domain;

public enum ResponseMessages
{
    NOT_EXIST("PARAMETER DOESNT EXIST"),
   NULL_RESPONSE("Parameter Shouldnt be NULL") ,
   ALREADY_EXIST_RESPONSE("PARAMETTER ALREADY EXIST")  ,
   CREATED_SUCCESFULY_RESPONSE("PARAMETTER CREATED SUCCESFULY ")  ;


    private final String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
