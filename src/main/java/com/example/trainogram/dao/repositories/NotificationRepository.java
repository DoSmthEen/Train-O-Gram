package com.example.trainogram.dao.repositories;

import com.example.trainogram.models.Notification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, ObjectId> {


}
