package com.example.trainogram.dao.repositories;

import com.example.trainogram.dao.entities.PostEntity;
import com.example.trainogram.dao.entities.UserEntity;
import com.example.trainogram.models.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAll();
//    List<PostEntity> findAllByAuthorId(String userId);
    List<Post> findAllByAuthorId(String id);
    List<Post> findAllByAuthorUsername(String username);
    void deleteAllByAuthorId(String id);
}
