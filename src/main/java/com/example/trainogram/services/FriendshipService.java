package com.example.trainogram.services;

import com.example.trainogram.models.User;

public interface FriendshipService {
    void addToFriends(User owner, User newFriend);
}
