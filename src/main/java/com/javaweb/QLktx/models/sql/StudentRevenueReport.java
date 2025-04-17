package com.javaweb.QLktx.models.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRevenueReport {
    private String studentId;
    private String studentName;
    private String roomNumber;
    private BigDecimal monthlyRoomFee;
    private BigDecimal totalServiceRevenue;
    private BigDecimal totalParkingFee;
    private BigDecimal totalRevenue;
}