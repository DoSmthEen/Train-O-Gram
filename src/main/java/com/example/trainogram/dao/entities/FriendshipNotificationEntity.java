package com.example.trainogram.dao.entities;

import com.example.trainogram.models.Notification;
import com.example.trainogram.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("friendship_notifications")
public class FriendshipNotificationEntity implements Notification {

    @Id
    private ObjectId id;
    private User owner;
    private User newFriend;

    public FriendshipNotificationEntity(User owner, User newFriend) {
        this.owner = owner;
        this.newFriend = newFriend;
    }
}
