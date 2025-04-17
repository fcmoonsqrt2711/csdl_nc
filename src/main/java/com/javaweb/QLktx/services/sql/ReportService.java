package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.MonthlyExpenseDTO;
import com.javaweb.QLktx.models.sql.StudentRevenueReport;
import com.javaweb.QLktx.repository.sql.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Cacheable(value = "monthlyStudentExpenses")
    public List<MonthlyExpenseDTO> getMonthlyExpenses() {
        List<Object[]> rawData = reportRepository.getMonthlyStudentExpenses();
        return rawData.stream().map(row ->
            new MonthlyExpenseDTO(
                (String) row[0],
                ((Long) row[1]),
                ((Date) row[2]),
                (BigDecimal) row[3]
            )
        ).collect(Collectors.toList());
    }
    @Cacheable(value = "studentRevenueReport")
    public List<StudentRevenueReport> getStudentRevenueReport() {
        List<Object[]> results = reportRepository.getStudentRevenueReport();
        List<StudentRevenueReport> reports = new ArrayList<>();

        for (Object[] row : results) {
            StudentRevenueReport report = new StudentRevenueReport();
            report.setStudentId((String) row[0]);
            report.setStudentName((String) row[1]);
            report.setRoomNumber((String) row[2]);
            report.setMonthlyRoomFee((BigDecimal) row[3]);
            report.setTotalServiceRevenue((BigDecimal) row[4]);
            report.setTotalParkingFee((BigDecimal) row[5]);
            report.setTotalRevenue((BigDecimal) row[6]);
            reports.add(report);
        }

        return reports;
    }
}
