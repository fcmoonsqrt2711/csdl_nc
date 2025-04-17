package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.VehicleInOut;

import java.util.List;
import java.util.Optional;

public interface VehicleInOutService {

    public List<VehicleInOut> getAllRecords();

    public Optional<VehicleInOut> getRecordById(Long id);

    public VehicleInOut saveRecord(VehicleInOut record);

    public void deleteRecord(Long id);
}
