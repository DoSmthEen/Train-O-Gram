package com.example.trainogram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Report {
    private ObjectId id;
    private List<ReportLine> lines;


    public Report(List<ReportLine> lines) {
        this.lines = lines;
    }
}
