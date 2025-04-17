package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.MonthlyParkingRegistration;
import com.javaweb.QLktx.services.sql.MonthlyParkingRegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class MonthlyParkingRegistrationController {
    private final MonthlyParkingRegistrationService service;

    public MonthlyParkingRegistrationController(MonthlyParkingRegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<MonthlyParkingRegistration> getAll() {
        return service.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public MonthlyParkingRegistration getById(@PathVariable Long id) {
        return service.getRegistrationById(id).orElse(null);
    }

    @PostMapping
    public MonthlyParkingRegistration create(@RequestBody MonthlyParkingRegistration registration) {
        return service.saveRegistration(registration);
    }

    @PutMapping("/{id}")
    public MonthlyParkingRegistration update(@PathVariable Long id, @RequestBody MonthlyParkingRegistration registration) {
        registration.setId(id);
        return service.saveRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRegistration(id);
    }
}
