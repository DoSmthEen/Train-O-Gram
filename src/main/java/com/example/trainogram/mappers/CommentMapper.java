package com.example.trainogram.mappers;

import com.example.trainogram.dto.CommentDto;
import com.example.trainogram.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment mapCommentDtoToComment(CommentDto commentDto);

}
