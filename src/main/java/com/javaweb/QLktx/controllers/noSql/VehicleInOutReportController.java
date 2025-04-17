package com.javaweb.QLktx.controllers.noSql;

import com.javaweb.QLktx.models.noSql.*;
import com.javaweb.QLktx.services.noSql.VehicleInOutReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports/vehicleInOut")
public class VehicleInOutReportController {

    private final VehicleInOutReportService service;

    @Autowired
    public VehicleInOutReportController(VehicleInOutReportService service) {
        this.service = service;
    }

    @GetMapping("/daily")
    public List<DailyVehicleInOutReport> getDailyVehicleInOutReport() {
        return service.getDailyVehicleInOutReport();
    }

    @GetMapping("/dailyRevenue")
    public List<DailyRevenueReport> getDailyRevenueReport() {
        return service.getDailyRevenueReport();
    }

    @GetMapping("/student")
    public List<StudentVehicleInOutReport> getStudentVehicleInOutReport() {
        return service.getStudentVehicleInOutReport();
    }

    @GetMapping("/studentRevenue")
    public List<StudentRevenueReport> getStudentRevenueReport() {
        return service.getStudentRevenueReport();
    }

    @GetMapping("/licensePlate")
    public List<LicensePlateVehicleInOutReport> getLicensePlateVehicleInOutReport() {
        return service.getLicensePlateVehicleInOutReport();
    }

    @GetMapping("/averageDurations")
    public List<AvgParkingDurationDTO> getAverageDurations() {
        return service.getAverageDurations();
    }
}