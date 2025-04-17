package com.javaweb.QLktx.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceRevenueDTO {
    private String serviceName;
    private int month;
    private int year;
    private BigDecimal revenue;

    // getters and setters
}