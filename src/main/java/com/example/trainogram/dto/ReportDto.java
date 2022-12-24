package com.example.trainogram.dto;

import com.example.trainogram.models.ReportLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
public class ReportDto {

    private List<ReportLine> lines;
}
