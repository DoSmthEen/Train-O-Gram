package com.example.trainogram.facades.implementation;

import com.example.trainogram.facades.FriendshipFacade;
import com.example.trainogram.models.FriendshipNotification;
import com.example.trainogram.models.User;
import com.example.trainogram.services.FriendshipService;
import com.example.trainogram.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FriendshipFacadeImpl implements FriendshipFacade {

    private FriendshipService friendshipService;
    private NotificationService notificationService;

    @Override
    public void addToFriends(User owner, User newFriend) {
        friendshipService.addToFriends(owner, newFriend);
        notificationService.sendNotification(
                new FriendshipNotification(owner, newFriend)
        );
    }
}
