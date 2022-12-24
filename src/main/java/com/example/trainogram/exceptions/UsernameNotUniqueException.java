package com.example.trainogram.exceptions;

public class UsernameNotUniqueException extends Exception{

    public UsernameNotUniqueException(String message) {
        super("username:"+ message + " already exist");
    }
}
