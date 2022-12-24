package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class SponsorPost extends Post{

    private String id;
    private User sponsor;

//    @Override
//    public List<User> getLikeNotificationRecipients() {
//        return Arrays.asList(getAuthor(), getSponsor());
//    }
}
