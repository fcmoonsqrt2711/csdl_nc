package com.javaweb.QLktx.services.noSql;

import com.javaweb.QLktx.models.noSql.*;
import com.javaweb.QLktx.repository.noSql.VehicleInOutReportRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleInOutReportService {

    private final VehicleInOutReportRepository repository;

    @Autowired
    public VehicleInOutReportService(VehicleInOutReportRepository repository) {
        this.repository = repository;
    }

    public List<DailyVehicleInOutReport> getDailyVehicleInOutReport() {
        List<Document> results = repository.getDailyVehicleInOutReport();
        List<DailyVehicleInOutReport> reports = new ArrayList<>();
        for (Document doc : results) {
            DailyVehicleInOutReport report = new DailyVehicleInOutReport();
            report.setDate(doc.getString("date"));
            report.setCount(doc.getLong("count"));
            reports.add(report);
        }
        return reports;
    }

    public List<DailyRevenueReport> getDailyRevenueReport() {
        List<Document> results = repository.getDailyRevenueReport();
        List<DailyRevenueReport> reports = new ArrayList<>();
        for (Document doc : results) {
            DailyRevenueReport report = new DailyRevenueReport();
            report.setDate(doc.getString("date"));
            report.setTotalFee(doc.getDouble("totalFee"));
            reports.add(report);
        }
        return reports;
    }

    public List<StudentVehicleInOutReport> getStudentVehicleInOutReport() {
        List<Document> results = repository.getStudentVehicleInOutReport();
        List<StudentVehicleInOutReport> reports = new ArrayList<>();
        for (Document doc : results) {
            StudentVehicleInOutReport report = new StudentVehicleInOutReport();
            report.setStudentId(doc.getString("studentId"));
            report.setCount(doc.getLong("count"));
            reports.add(report);
        }
        return reports;
    }

    public List<StudentRevenueReport> getStudentRevenueReport() {
        List<Document> results = repository.getStudentRevenueReport();
        List<StudentRevenueReport> reports = new ArrayList<>();
        for (Document doc : results) {
            StudentRevenueReport report = new StudentRevenueReport();
            report.setStudentId(doc.getString("studentId"));
            report.setTotalFee(doc.getDouble("totalFee"));
            reports.add(report);
        }
        return reports;
    }

    public List<LicensePlateVehicleInOutReport> getLicensePlateVehicleInOutReport() {
        List<Document> results = repository.getLicensePlateVehicleInOutReport();
        List<LicensePlateVehicleInOutReport> reports = new ArrayList<>();
        for (Document doc : results) {
            LicensePlateVehicleInOutReport report = new LicensePlateVehicleInOutReport();
            report.setLicensePlate(doc.getString("licensePlate"));
            report.setCount(doc.getLong("count"));
            reports.add(report);
        }
        return reports;
    }

    public List<AvgParkingDurationDTO> getAverageDurations() {
        return repository.getAverageParkingDurations();
    }
}