package com.example.trainogram.dao.entities;

import com.example.trainogram.models.Notification;
import com.example.trainogram.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("like_notifications")
public class LikeNotificationEntity implements Notification {

    @Id
    private ObjectId id;
    private User author;
    private User whoLikes;

    public LikeNotificationEntity(User author, User whoLikes) {
        this.author = author;
        this.whoLikes = whoLikes;
    }
}
