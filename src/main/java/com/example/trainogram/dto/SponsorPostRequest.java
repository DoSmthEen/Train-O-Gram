package com.example.trainogram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SponsorPostRequest extends PostRequest {

    private String sponsorId;

//    @Override
//    public List<User> getLikeNotificationRecipients() {
//        return Arrays.asList(getAuthor(), getSponsor());
//    }
}
