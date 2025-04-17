package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.StudentServiceUsage;
import com.javaweb.QLktx.services.sql.StudentServiceUsageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-usage")
public class StudentServiceUsageController {
    private final StudentServiceUsageService service;

    public StudentServiceUsageController(StudentServiceUsageService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentServiceUsage> getAll() {
        return service.getAllUsages();
    }

    @GetMapping("/{id}")
    public StudentServiceUsage getById(@PathVariable Long id) {
        return service.getUsageById(id).orElse(null);
    }

    @PostMapping
    public StudentServiceUsage create(@RequestBody StudentServiceUsage usage) {
        return service.saveUsage(usage);
    }

    @PutMapping("/{id}")
    public StudentServiceUsage update(@PathVariable Long id, @RequestBody StudentServiceUsage usage) {
        usage.setId(id);
        return service.saveUsage(usage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUsage(id);
    }
}
