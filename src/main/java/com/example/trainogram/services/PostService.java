package com.example.trainogram.services;

import com.example.trainogram.dto.PostRequest;
import com.example.trainogram.exceptions.PostNotFoundException;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.models.Post;

import java.net.UnknownHostException;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(String postId) throws PostNotFoundException;
    List<Post> getAllPostsByAuthorUsername(String username);
    List<Post> getAllRecommendations(String username);
    Post createPost(PostRequest postRequest, String userToken) throws UnknownHostException;
    void deleteAllPostsRelatedToUser(String id);
    void getAllPostsByAuthorId(String id) throws UserNotFoundException;
    Post updatePost(PostRequest postRequest, String username) throws PostNotFoundException, UnknownHostException;
    void deletePost(String id);
}
