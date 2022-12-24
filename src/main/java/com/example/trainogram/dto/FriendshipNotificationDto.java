package com.example.trainogram.dto;

import com.example.trainogram.models.Notification;
import com.example.trainogram.models.User;
import lombok.Data;

@Data
public class FriendshipNotificationDto implements Notification {

    private String ownerId;
    private String newFriendId;
}
