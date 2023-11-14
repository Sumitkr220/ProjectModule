package com.example.Registration.customException;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not present for this Id");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
