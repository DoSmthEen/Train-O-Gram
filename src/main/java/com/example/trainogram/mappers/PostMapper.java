package com.example.trainogram.mappers;

import com.example.trainogram.dao.entities.PostEntity;
import com.example.trainogram.dto.PostRequest;
import com.example.trainogram.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    public UserMapper userMapper;
    @Mapping(target = "caption", source = "caption")
    public abstract Post mapPostRequestToPost(PostRequest postRequest);


}
