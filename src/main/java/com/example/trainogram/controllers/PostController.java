package com.example.trainogram.controllers;

import com.auth0.jwt.JWT;
import com.example.trainogram.dto.PostRequest;
import com.example.trainogram.exceptions.PostNotFoundException;
import com.example.trainogram.mappers.PostMapper;
import com.example.trainogram.models.Post;
import com.example.trainogram.security.JwtUtil;
import com.example.trainogram.services.PostService;
import com.example.trainogram.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PostMapper postMapper;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@ModelAttribute @RequestBody PostRequest postRequest, @RequestHeader("Authorization") String userToken) throws IOException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/posts/create").toUriString());
        return ResponseEntity.created(uri).body(postService.createPost(
                postRequest,
                jwtUtil.getUsername(userToken)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@ModelAttribute @RequestBody PostRequest postRequest,
                                        @PathVariable String id,
                                        @RequestHeader("Authorization") String userToken) throws UnknownHostException, PostNotFoundException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/posts/update").toUriString());
        postRequest.setId(id);
        return ResponseEntity.created(uri).body(postService.updatePost(postRequest, jwtUtil.getUsername(userToken)));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @GetMapping("/by-user")
    public ResponseEntity<List<Post>> getAllPostsByUser(@RequestParam String username) {
        return ResponseEntity.ok().body(postService.getAllPostsByAuthorUsername(username));
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<Post>> getAllRecommendations(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok().body(postService.getAllRecommendations(jwtUtil.getUsername(token)));
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deletePost(){
//
//    }
}