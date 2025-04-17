package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.Dto.ServiceRevenueDTO;
import com.javaweb.QLktx.Dto.StudentMonthlyPaymentDTO;
import com.javaweb.QLktx.Dto.StudentServiceCostDTO;
import com.javaweb.QLktx.Dto.StudentVisitorDTO;
import com.javaweb.QLktx.repository.sql.*;
import com.javaweb.QLktx.services.sql.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentServiceUsageRepository studentServiceUsageRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MonthlyParkingRegistrationRepository parkingRepository;

    @Override
    public List<StudentMonthlyPaymentDTO> getStudentMonthlyPayments() {
        return invoiceRepository.getStudentMonthlyPayments();
    }

    @Override
    public List<StudentServiceCostDTO> getStudentServiceCostBetween(LocalDateTime start, LocalDateTime end) {
        return studentServiceUsageRepository.getStudentServiceCostBetween(start, end);
    }

    @Override
    public List<StudentVisitorDTO> getVisitorsBetween(LocalDate start, LocalDate end) {
        return visitorRepository.getVisitorsBetween(start, end);
    }

    @Override
    public List<ServiceRevenueDTO> getMonthlyServiceRevenue() {
        return studentServiceUsageRepository.getMonthlyServiceRevenue();
    }

    @Override
    public List<Object[]> getRoomsOverCapacity() {
        return roomRepository.getRoomsOverCapacity();
    }

    @Override
    public List<Object[]> getStudentsOverVehicleLimit() {
        return parkingRepository.getStudentsOverVehicleLimit();
    }
}
