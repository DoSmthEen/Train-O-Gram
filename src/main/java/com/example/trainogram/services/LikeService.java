package com.example.trainogram.services;

import com.example.trainogram.models.Post;
import com.example.trainogram.models.User;

public interface LikeService {
    void likePost(Post post, User whoLikes);
}
