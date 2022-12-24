package com.example.trainogram.services.implementation;

import com.example.trainogram.services.PostService;
import com.example.trainogram.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private PostService postService;

//    @Override
//    public Report buildReport(User user) {
//        return new Report(postService.getAllPostsByUser(user).stream()
//                .map(post -> new ReportLine(post, post.getLikesCount()))
//                .collect(Collectors.toList()));
//    }
//
//    @Override
//    public Report buildSponsoredReport(User user) {
//        return new Report(postService.getAllPostsByUser(user).stream()
//                .filter(post -> post instanceof SponsorPost)
//                .map(post -> new ReportLine(post, post.getLikesCount()))
//                .collect(Collectors.toList()));
//    }
}
