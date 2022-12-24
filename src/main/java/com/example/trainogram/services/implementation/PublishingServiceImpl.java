package com.example.trainogram.services.implementation;

import com.example.trainogram.services.PostService;
import com.example.trainogram.services.PublishingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PublishingServiceImpl implements PublishingService {

    PostService postService;

//    @Override
//    public Post publishPost(User author, Picture picture) {
//        Post newPost = new Post();
//        newPost.setPicture(picture);
//        newPost.setAuthor(author);
//        newPost.setPubDate(LocalDate.now());
//        return postService.save(newPost);
//    }
}
