package com.example.trainogram.dao.repositories;

import com.example.trainogram.models.Friendship;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendshipRepository extends MongoRepository<Friendship, ObjectId> {
}
