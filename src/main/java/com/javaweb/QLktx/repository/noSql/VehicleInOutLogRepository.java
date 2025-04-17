package com.javaweb.QLktx.repository.noSql;

import com.javaweb.QLktx.models.noSql.VehicleInOutLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleInOutLogRepository extends MongoRepository<VehicleInOutLog, String> {

    List<VehicleInOutLog> findByLicensePlate(String licensePlate);

    List<VehicleInOutLog> findByStudentId(String studentId);

    List<VehicleInOutLog> findByTimeInBetween(LocalDateTime start, LocalDateTime end);
}
