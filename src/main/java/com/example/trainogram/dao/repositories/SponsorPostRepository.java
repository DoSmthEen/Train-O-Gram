package com.example.trainogram.dao.repositories;

import com.example.trainogram.dto.SponsorPostRequest;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SponsorPostRepository extends MongoRepository<SponsorPostRequest, ObjectId> {

}
