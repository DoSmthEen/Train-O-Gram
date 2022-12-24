package com.example.trainogram.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("posts")
public class PostEntity {

    @Id
    private String id;
    @DBRef
    private UserEntity author;
    @CreatedDate
    private LocalDateTime pubDate;
    @DBRef
    private List<CommentEntity> comments;
    private List<String> picturesUrls;
    @NonNull
    private String caption;

//    public PostEntity(List<CommentEntity> comments) {
//        this.comments = comments;
//    }

//    public void addComment(Comment comment){
//        comments.add(comment);
//    }
//
//    public void addLike(){
//        this.likesCount++;
//    }

//    @Override
//    public List<User> getLikeNotificationRecipients() {
//        return List.of(getAuthor());
//    }
}
