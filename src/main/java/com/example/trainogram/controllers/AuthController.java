package com.example.trainogram.controllers;

import com.example.trainogram.dto.CustomResponseEntity;
import com.example.trainogram.dto.UserRequest;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.exceptions.UsernameNotUniqueException;
import com.example.trainogram.models.User;
import com.example.trainogram.security.JwtUtil;
import com.example.trainogram.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody UserRequest userRequest) throws UsernameNotUniqueException{
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/signup").toUriString());
        return ResponseEntity.created(uri).body(authService.signUp(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<User> signIn(@RequestBody UserRequest userRequest) throws UsernameNotUniqueException{
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/signin").toUriString());
        return ResponseEntity.created(uri).body(authService.signUp(userRequest));
    }

    @PostMapping("/update-avatar")
    public ResponseEntity<String> updateProfilePicture(@RequestParam MultipartFile avatar,
                                                  @RequestHeader("Authorization") String userToken) throws UnknownHostException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/update-avatar").toUriString());
        return ResponseEntity.created(uri).body(authService.updateProfilePicture(avatar, jwtUtil.getUsername(userToken)));
    }

    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity.BodyBuilder deleteAccount(@PathVariable String id) throws UserNotFoundException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/delete-account").toUriString());
        authService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK);
    }
}
