package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportLine {
    private Post post;
    private int likesCount;
}
