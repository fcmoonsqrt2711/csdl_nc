package com.javaweb.QLktx.services.noSql;


import com.javaweb.QLktx.models.noSql.VehicleInOutLog;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleLogService {
    VehicleInOutLog saveLog(VehicleInOutLog log);

    List<VehicleInOutLog> getLogsByLicensePlate(String plate);

    List<VehicleInOutLog> getLogsByStudentId(String studentId);

    List<VehicleInOutLog> getLogsInRange(LocalDateTime start, LocalDateTime end);
}