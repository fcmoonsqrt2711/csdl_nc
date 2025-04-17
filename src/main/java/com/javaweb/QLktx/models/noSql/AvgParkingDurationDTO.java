package com.javaweb.QLktx.models.noSql;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvgParkingDurationDTO {
    private String studentId;
    private Double avgDuration;

    public AvgParkingDurationDTO(String studentId, Double avgDuration) {
        this.studentId = studentId;
        this.avgDuration = avgDuration;
    }

    // getters and setters
}
