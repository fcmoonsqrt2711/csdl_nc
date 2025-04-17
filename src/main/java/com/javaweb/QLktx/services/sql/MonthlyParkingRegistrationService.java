package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.MonthlyParkingRegistration;

import java.util.List;
import java.util.Optional;

public interface MonthlyParkingRegistrationService {

    public List<MonthlyParkingRegistration> getAllRegistrations() ;

    public Optional<MonthlyParkingRegistration> getRegistrationById(Long id) ;

    public MonthlyParkingRegistration saveRegistration(MonthlyParkingRegistration registration) ;

    public void deleteRegistration(Long id);
}
