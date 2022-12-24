package com.example.trainogram.controllers;

import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.mappers.UserMapper;
import com.example.trainogram.models.User;
import com.example.trainogram.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(String authToken) {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) throws UsernameNotFoundException {
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) throws UserNotFoundException {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


}
//                    ⠀⢳⠀⠀⣼⣿⣿⣿⣿⣿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁
//                    ⢰⠆⠁⠠⣿⣿⡁⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿
//                    ⣾⢠⠀⠀⢻⣿⣿⣦⣀⠀⠠⣀⡒⠀⠀⠀⠀⣸⣿⡇⠀⠀⠀⡀⠈⡈
//                    ⢨⣿⡄⠀⠘⣿⣿⣿⣿⣷⣶⣶⣶⣦⣶⣶⣶⣿⣿⣷⣤⣄⣰⣧⣴⡇
//                    ⠈⠻⠇⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁
//                         ⢸⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟
//                         ⠸⣿⣿⣿⣿⣿⣿⣿⣿⠀⠉⠉⠻⠿⣿⣿⣿⣿⣿⠃
//                          ⠻⣿⣿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣿⣿⣿⣿⣿⡟
//                           ⠘⢿⣿⣟⠹⠟⠛⠛⠛⠛⠟⠛⠿⢿⣿⡟
//                             ⠉⠑⠈⠛⠓⠿⠶⠶⠶⠿⣶⠶""";
