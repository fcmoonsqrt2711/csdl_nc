package com.javaweb.QLktx.controllers.noSql;

import com.javaweb.QLktx.models.noSql.VehicleInOutLog;
import com.javaweb.QLktx.services.noSql.VehicleLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle-log")
public class VehicleLogController {

    private final VehicleLogService vehicleLogService;

    public VehicleLogController(VehicleLogService vehicleLogService) {
        this.vehicleLogService = vehicleLogService;
    }

    @PostMapping
    public VehicleInOutLog createLog(@RequestBody VehicleInOutLog log) {
        return vehicleLogService.saveLog(log);
    }

    @GetMapping("/plate/{licensePlate}")
    public List<VehicleInOutLog> getByPlate(@PathVariable String licensePlate) {
        return vehicleLogService.getLogsByLicensePlate(licensePlate);
    }

    @GetMapping("/student/{studentId}")
    public List<VehicleInOutLog> getByStudent(@PathVariable String studentId) {
        return vehicleLogService.getLogsByStudentId(studentId);
    }

    @GetMapping("/range")
    public List<VehicleInOutLog> getByTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return vehicleLogService.getLogsInRange(start, end);
    }
}
