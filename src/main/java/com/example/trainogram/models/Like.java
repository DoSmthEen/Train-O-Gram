package com.example.trainogram.models;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Like {
    private ObjectId id;
    private Post post;
    private User whoLikes;


    public Like(Post post, User whoLikes) {
        this.post = post;
        this.whoLikes = whoLikes;
    }
}
