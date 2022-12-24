package com.example.trainogram.dao.repositories;

import com.example.trainogram.dao.entities.CommentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity, ObjectId> {
    List<CommentEntity> findAll();
}