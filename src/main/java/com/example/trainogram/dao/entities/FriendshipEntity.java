package com.example.trainogram.dao.entities;

import com.example.trainogram.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("friendships")
public class FriendshipEntity {

    @Id
    private ObjectId id;
    private User owner;
    private User newFriend;

    public FriendshipEntity(User owner, User newFriend) {
        this.owner = owner;
        this.newFriend = newFriend;
    }
}
