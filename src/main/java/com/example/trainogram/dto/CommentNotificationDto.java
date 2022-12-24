package com.example.trainogram.dto;

import com.example.trainogram.models.Comment;
import com.example.trainogram.models.Notification;
import com.example.trainogram.models.Post;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CommentNotificationDto implements Notification {

    private String postId;
    private String commentId;

}
