package com.example.trainogram.services.implementation;

import com.example.trainogram.dao.repositories.LikeRepository;
import com.example.trainogram.models.Like;
import com.example.trainogram.models.Post;
import com.example.trainogram.models.User;
import com.example.trainogram.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private LikeRepository likeRepository;

    @Override
    public void likePost(Post post, User whoLikes) {
        likeRepository.save(new Like(post, whoLikes));


    }
}
