package com.example.trainogram.dao.repositories;

import com.example.trainogram.models.PictureMetaData;
import com.example.trainogram.models.PictureUsages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMetadataRepository extends MongoRepository<PictureMetaData, String> {
    List<PictureMetaData> findAllByAuthorIdAndUsage(String id, PictureUsages pictureUsage);
    void deleteAllByAuthorId(String id);

}
