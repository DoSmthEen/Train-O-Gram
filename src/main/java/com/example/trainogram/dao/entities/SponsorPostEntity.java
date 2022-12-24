package com.example.trainogram.dao.entities;

import com.example.trainogram.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("sponsor_posts")
public class SponsorPostEntity extends PostEntity {

    private String id;
    private User sponsor;

//    @Override
//    public List<User> getLikeNotificationRecipients() {
//        return Arrays.asList(getAuthor(), getSponsor());
//    }
}
