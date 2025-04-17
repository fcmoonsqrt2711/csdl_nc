package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.MonthlyParkingRegistration;
import com.javaweb.QLktx.repository.sql.MonthlyParkingRegistrationRepository;
import com.javaweb.QLktx.services.sql.MonthlyParkingRegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyParkingRegistrationServiceImpl implements MonthlyParkingRegistrationService {
    private final MonthlyParkingRegistrationRepository repository;

    public MonthlyParkingRegistrationServiceImpl(MonthlyParkingRegistrationRepository repository) {
        this.repository = repository;
    }

    public List<MonthlyParkingRegistration> getAllRegistrations() {
        return repository.findAll();
    }

    public Optional<MonthlyParkingRegistration> getRegistrationById(Long id) {
        return repository.findById(id);
    }

    public MonthlyParkingRegistration saveRegistration(MonthlyParkingRegistration registration) {
        return repository.save(registration);
    }

    public void deleteRegistration(Long id) {
        repository.deleteById(id);
    }
}
