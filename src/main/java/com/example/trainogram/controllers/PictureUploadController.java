package com.example.trainogram.controllers;

import com.example.trainogram.models.PictureMetaData;
import com.example.trainogram.security.JwtUtil;
import com.example.trainogram.services.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/images")
@AllArgsConstructor
public class PictureUploadController {

    private final PictureService pictureService;
    private final JwtUtil jwtUtil;

    @PostMapping("/upload")
    public ResponseEntity<List<PictureMetaData>> uploadImage(@RequestParam("pictures") List<MultipartFile> pictures,
                                                             @RequestHeader("Authorization") String userToken) throws UnknownHostException {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/upload").toUriString());

        return ResponseEntity.created(uri).body(pictureService.uploadPicture(pictures, jwtUtil.getUsername(userToken), null));
    }
}
