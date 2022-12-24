package com.example.trainogram.dao.entities;

import com.example.trainogram.models.Comment;
import com.example.trainogram.models.Notification;
import com.example.trainogram.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("comment_notifications")
public class CommentNotificationEntity implements Notification {

    @Id
    private ObjectId id;
    private Post post;
    private Comment comment;


    public CommentNotificationEntity(Post post, Comment comment) {
        this.post = post;
        this.comment = comment;
    }
}