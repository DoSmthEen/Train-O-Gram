package com.example.trainogram.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String id){
        super("user by id " + id + "not found");
    }
}
