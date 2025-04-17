package com.javaweb.QLktx.models.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MonthlyExpenseDTO {
    private String studentId;
    private Long month;
    private Date year;
    private BigDecimal monthlyTotal;

}
