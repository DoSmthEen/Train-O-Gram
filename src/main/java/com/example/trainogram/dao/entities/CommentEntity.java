package com.example.trainogram.dao.entities;

import com.example.trainogram.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("comments")
public class CommentEntity {

    @Id
    private String id;
    private User author;
    private String text;
    @CreatedDate
    private Date published;

    public CommentEntity(User author, String text, Date published) {
        this.author = author;
        this.text = text;
        this.published = published;
    }

}
