// StudentServiceUsageRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.Dto.ServiceRevenueDTO;
import com.javaweb.QLktx.Dto.StudentServiceCostDTO;
import com.javaweb.QLktx.models.sql.StudentServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentServiceUsageRepository extends JpaRepository<StudentServiceUsage, Long> {

    @Query("SELECT StudentServiceCostDTO(" +
            "u.student.studentID, u.student.name, sv.serviceName, SUM(sv.unitPrice)) " +
            "FROM StudentServiceUsage u " +
            "JOIN u.student s " +
            "JOIN u.serviceKtx sv " +
            "WHERE u.usageTime BETWEEN :start AND :end " +
            "GROUP BY u.student.studentID, u.student.name, sv.serviceName")
    List<StudentServiceCostDTO> getStudentServiceCostBetween(LocalDateTime start, LocalDateTime end);


    @Query("SELECT ServiceRevenueDTO(sv.serviceName, MONTH(u.usageTime), YEAR(u.usageTime), SUM(sv.unitPrice)) " +
            "FROM StudentServiceUsage u " +
            "JOIN u.serviceKtx sv " +
            "GROUP BY sv.serviceName, MONTH(u.usageTime), YEAR(u.usageTime)")
    List<ServiceRevenueDTO> getMonthlyServiceRevenue();
}
