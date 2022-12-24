package com.example.trainogram.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostRequest {

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    private String id;
    private List<MultipartFile> pictures;
    private String caption;

}
