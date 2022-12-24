package com.example.trainogram.services;

import com.example.trainogram.dto.UserRequest;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.exceptions.UsernameNotUniqueException;
import com.example.trainogram.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;

public interface AuthService {
    User signUp(UserRequest userRequest) throws UsernameNotUniqueException;
    void deleteAccount(String id) throws UserNotFoundException;
    String updateProfilePicture(MultipartFile avatar, String username) throws UnknownHostException;
}
