package com.example.trainogram.facades;

import com.example.trainogram.models.Post;
import com.example.trainogram.models.User;

public interface LikeFacade {
    void likePost(Post post, User whoLikes);
}
