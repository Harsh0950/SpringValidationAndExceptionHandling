package com.green.validationAndExceptionHandling.excepitons;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
