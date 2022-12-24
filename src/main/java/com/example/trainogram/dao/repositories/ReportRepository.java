package com.example.trainogram.dao.repositories;

import com.example.trainogram.dao.entities.ReportEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<ReportEntity, ObjectId> {

}
