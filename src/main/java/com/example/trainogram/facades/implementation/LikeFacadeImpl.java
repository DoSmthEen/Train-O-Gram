package com.example.trainogram.facades.implementation;

import com.example.trainogram.facades.LikeFacade;
import com.example.trainogram.models.LikeNotification;
import com.example.trainogram.models.Post;
import com.example.trainogram.models.User;
import com.example.trainogram.services.LikeService;
import com.example.trainogram.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LikeFacadeImpl{

    private LikeService likeService;
    private NotificationService notificationService;

//    @Override
//    public void likePost(Post post, User whoLikes) {
//        likeService.likePost(post, whoLikes);
//        for (User recipient:post.getLikeNotificationRecipients()){
//            notificationService.sendNotification(new LikeNotification(recipient, whoLikes));
//        }
//
//    }
}
