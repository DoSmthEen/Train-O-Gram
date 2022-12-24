package com.example.trainogram.models;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class LikeNotification implements Notification{

    private ObjectId id;
    private User author;
    private User whoLikes;

    public LikeNotification(User author, User whoLikes) {
        this.author = author;
        this.whoLikes = whoLikes;
    }
}
