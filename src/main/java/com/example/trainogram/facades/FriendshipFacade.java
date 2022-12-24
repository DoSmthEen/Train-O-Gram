package com.example.trainogram.facades;

import com.example.trainogram.models.User;

public interface FriendshipFacade {
    void addToFriends(User owner, User newFriend);
}
