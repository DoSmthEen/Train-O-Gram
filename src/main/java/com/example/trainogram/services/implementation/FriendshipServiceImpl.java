package com.example.trainogram.services.implementation;

import com.example.trainogram.dao.repositories.FriendshipRepository;
import com.example.trainogram.models.Friendship;
import com.example.trainogram.models.User;
import com.example.trainogram.services.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FriendshipServiceImpl implements FriendshipService {

    FriendshipRepository friendshipRepository;

    @Override
    public void addToFriends(User owner, User newFriend) {
        friendshipRepository.save(new Friendship(owner, newFriend));
    }
}
