package com.javaweb.QLktx.services.sql;


import com.javaweb.QLktx.Dto.ServiceRevenueDTO;
import com.javaweb.QLktx.Dto.StudentMonthlyPaymentDTO;
import com.javaweb.QLktx.Dto.StudentServiceCostDTO;
import com.javaweb.QLktx.Dto.StudentVisitorDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface QueryService {

    List<StudentMonthlyPaymentDTO> getStudentMonthlyPayments();

    List<StudentServiceCostDTO> getStudentServiceCostBetween(LocalDateTime start, LocalDateTime end);

    List<StudentVisitorDTO> getVisitorsBetween(LocalDate start, LocalDate end);

    List<ServiceRevenueDTO> getMonthlyServiceRevenue();

    List<Object[]> getRoomsOverCapacity();

    List<Object[]> getStudentsOverVehicleLimit();
} 
