package com.example.trainogram.controllers;

import com.example.trainogram.facades.CommentFacade;
import com.example.trainogram.mappers.CommentMapper;
import com.example.trainogram.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentFacade commentFacade;
    private PostService postService;
    private CommentMapper commentMapper;

//    @PostMapping("/Sraka/{postId}/add-comment")
//    public ResponseEntity<Void> addComment(@RequestBody CommentDto commentDto,
//                                           @PathVariable String postId){
//
//        Post post = postService.getPostById(postId);
//        commentFacade.addComment(post, commentMapper.mapCommentDtoToComment(commentDto));
//        return new ResponseEntity<>(CREATED);
//    }
}
