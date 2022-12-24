package com.example.trainogram.services;

import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserByUsername(String username);
    User getUserById(String username) throws UserNotFoundException;
    List<User> getUsers();
    void deleteUserById(String id) throws UserNotFoundException;
}
