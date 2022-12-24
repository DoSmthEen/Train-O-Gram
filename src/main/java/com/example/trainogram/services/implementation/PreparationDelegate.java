package com.example.trainogram.services.implementation;

import com.example.trainogram.services.PreparationService;
import com.example.trainogram.services.PublishingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PreparationDelegate {

    PreparationService preparationService;
    PublishingService publishingService;

//    public void runPreparation(User user, Picture picture){
//        List<Filter> filters = Arrays.asList(
//                new KekFilter(),
//                new ChmukFilter()
//        );
//        Picture preparedPicture = preparationService.prepare(picture, filters);
//        publishingService.publishPost(user, preparedPicture);
//    }
}
