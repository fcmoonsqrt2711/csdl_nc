package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.VehicleInOut;
import com.javaweb.QLktx.repository.sql.VehicleInOutRepository;
import com.javaweb.QLktx.services.sql.VehicleInOutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleInOutServiceImpl implements VehicleInOutService {
    private final VehicleInOutRepository repository;

    public VehicleInOutServiceImpl(VehicleInOutRepository repository) {
        this.repository = repository;
    }

    public List<VehicleInOut> getAllRecords() {
        return repository.findAll();
    }

    public Optional<VehicleInOut> getRecordById(Long id) {
        return repository.findById(id);
    }

    public VehicleInOut saveRecord(VehicleInOut record) {
        return repository.save(record);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
