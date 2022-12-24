package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
public class Friendship {

    private ObjectId id;
    private User owner;
    private User newFriend;

    public Friendship(User owner, User newFriend) {
        this.owner = owner;
        this.newFriend = newFriend;
    }
}
