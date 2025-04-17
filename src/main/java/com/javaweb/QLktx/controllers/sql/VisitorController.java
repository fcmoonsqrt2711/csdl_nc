package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.Visitor;
import com.javaweb.QLktx.services.sql.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Visitor> getAll() {
        return service.getAllVisitors();
    }

    @GetMapping("/{nationalId}")
    public Visitor getById(@PathVariable String nationalId) {
        return service.getVisitorByNationalId(nationalId).orElse(null);
    }

    @PostMapping
    public Visitor create(@RequestBody Visitor visitor) {
        return service.saveVisitor(visitor);
    }

    @PutMapping("/{nationalId}")
    public Visitor update(@PathVariable String nationalId, @RequestBody Visitor visitor) {
        visitor.setNationalID(nationalId);
        return service.saveVisitor(visitor);
    }

    @DeleteMapping("/{nationalId}")
    public void delete(@PathVariable String nationalId) {
        service.deleteVisitor(nationalId);
    }
}
