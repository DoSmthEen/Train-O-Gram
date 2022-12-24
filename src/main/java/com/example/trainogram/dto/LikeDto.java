package com.example.trainogram.dto;

import com.example.trainogram.models.Post;
import com.example.trainogram.models.User;
import lombok.Data;

@Data
public class LikeDto {

    private String postId;
    private String whoLikesId;

}
