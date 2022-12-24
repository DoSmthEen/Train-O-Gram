package com.example.trainogram.exceptions;

public class PostNotFoundException extends Exception{
    public PostNotFoundException(String id){
        super("post by id " + id + "not found");
    }
}
