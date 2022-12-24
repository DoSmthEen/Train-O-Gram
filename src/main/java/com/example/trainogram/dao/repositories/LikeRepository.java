package com.example.trainogram.dao.repositories;

import com.example.trainogram.models.Like;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, ObjectId> {
}
