package com.example.trainogram.services;

import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.models.PictureMetaData;
import com.example.trainogram.models.PictureUsages;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;
import java.util.List;

public interface PictureService {
    List<PictureMetaData> uploadPicture(List<MultipartFile> pictures, String username, PictureUsages usage) throws UnknownHostException;
    void deleteAllUserDirectories(String id) throws UserNotFoundException;
    void deleteAllPictureMetadataRelatedToUser(String id);
}
