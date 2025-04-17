package com.javaweb.QLktx.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentMonthlyPaymentDTO {
    private String studentId;
    private String studentName;
    private int month;
    private int year;
    private BigDecimal totalAmount;

    // getters and setters
}