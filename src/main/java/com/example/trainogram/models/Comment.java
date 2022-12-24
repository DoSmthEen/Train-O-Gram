package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String id;
    private User author;
    private String text;
    private LocalDate published;

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
    }
}
