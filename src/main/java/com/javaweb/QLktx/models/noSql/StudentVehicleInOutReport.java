package com.javaweb.QLktx.models.noSql;

import lombok.Data;

@Data
public class StudentVehicleInOutReport {
    private String studentId;
    private long count;
}