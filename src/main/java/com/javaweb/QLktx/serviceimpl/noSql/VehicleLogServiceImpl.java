package com.javaweb.QLktx.serviceimpl.noSql;

import com.javaweb.QLktx.models.noSql.VehicleInOutLog;
import com.javaweb.QLktx.repository.noSql.VehicleInOutLogRepository;
import com.javaweb.QLktx.services.noSql.VehicleLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleLogServiceImpl implements VehicleLogService {

    private final VehicleInOutLogRepository repository;

    public VehicleLogServiceImpl(VehicleInOutLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleInOutLog saveLog(VehicleInOutLog log) {
        return repository.save(log);
    }

    @Override
    public List<VehicleInOutLog> getLogsByLicensePlate(String plate) {
        return repository.findByLicensePlate(plate);
    }

    @Override
    public List<VehicleInOutLog> getLogsByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<VehicleInOutLog> getLogsInRange(LocalDateTime start, LocalDateTime end) {
        return repository.findByTimeInBetween(start, end);
    }
}