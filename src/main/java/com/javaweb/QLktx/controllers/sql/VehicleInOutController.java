package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.VehicleInOut;
import com.javaweb.QLktx.services.sql.VehicleInOutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleInOutController {
    private final VehicleInOutService service;

    public VehicleInOutController(VehicleInOutService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleInOut> getAll() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public VehicleInOut getById(@PathVariable Long id) {
        return service.getRecordById(id).orElse(null);
    }

    @PostMapping
    public VehicleInOut create(@RequestBody VehicleInOut record) {
        return service.saveRecord(record);
    }

    @PutMapping("/{id}")
    public VehicleInOut update(@PathVariable Long id, @RequestBody VehicleInOut record) {
        record.setId(id);
        return service.saveRecord(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
