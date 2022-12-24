package com.example.trainogram.dao.entities;

import com.example.trainogram.models.ReportLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document("reports")
public class ReportEntity {

    @Id
    private ObjectId id;
    private List<ReportLine> lines;

    public ReportEntity(List<ReportLine> lines) {
        this.lines = lines;
    }
}
