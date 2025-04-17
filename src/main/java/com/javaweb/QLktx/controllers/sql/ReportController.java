package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.MonthlyExpenseDTO;
import com.javaweb.QLktx.models.sql.StudentRevenueReport;
import com.javaweb.QLktx.services.sql.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/monthly-expenses")
    public ResponseEntity<List<MonthlyExpenseDTO>> getMonthlyExpenses() {
        return ResponseEntity.ok(reportService.getMonthlyExpenses());
    }
    @GetMapping("/student-revenue-report")
    public ResponseEntity<List<StudentRevenueReport>> getStudentRevenueReport() {
        return ResponseEntity.ok(reportService.getStudentRevenueReport());
    }
}
