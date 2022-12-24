package com.example.trainogram.mappers;

import com.example.trainogram.dao.entities.UserEntity;
import com.example.trainogram.dto.UserRequest;
import com.example.trainogram.dto.response.UserResponse;
import com.example.trainogram.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "name",source = "name")
    UserEntity mapUserToUserEntity(User user);
    UserResponse mapUserToUserResponse(User user);
    User mapUserEntityToUser(UserEntity userEntity);
    User mapUserRequestToUser(UserRequest userRequest);
    UserResponse mapUserEntityToUserResponse(UserEntity user);
}
