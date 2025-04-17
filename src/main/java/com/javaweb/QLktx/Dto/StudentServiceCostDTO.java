package com.javaweb.QLktx.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceCostDTO {
    private String studentId;
    private String studentName;
    private String serviceName;
    private BigDecimal totalCost;

    // getters and setters
}