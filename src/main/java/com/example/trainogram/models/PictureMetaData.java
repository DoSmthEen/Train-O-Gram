package com.example.trainogram.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
@Document("pictures_meta_data")
public class PictureMetaData {

    @Id
    private String id;
    @DBRef
    private User author;
    private PictureUsages usage;
    @CreatedDate
    private LocalDateTime createdDate;
    private String filename;
    private String uri;
    private String fileType;

    public PictureMetaData(User author, PictureUsages usage, String filename, String uri, String fileType) {
        this.author = author;
        this.usage = usage;
        this.filename = filename;
        this.uri = uri;
        this.fileType = fileType;
    }
}
