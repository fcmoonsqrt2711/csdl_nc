package com.javaweb.QLktx.models.noSql;

import lombok.Data;

@Data
public class DailyVehicleInOutReport {
    private String date;
    private long count;
}