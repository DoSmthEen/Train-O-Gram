package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
public class CommentNotification implements Notification{

    private ObjectId id;
    private Post post;
    private Comment comment;
    private String message;

    public CommentNotification(Post post, Comment comment, String message) {
        this.post = post;
        this.comment = comment;
    }
}