package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.ServiceKtx;
import com.javaweb.QLktx.services.sql.ServiceKtxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceKtxController {
    private final ServiceKtxService serviceKtx;

    public ServiceKtxController(ServiceKtxService serviceKtx) {
        this.serviceKtx = serviceKtx;
    }

    @GetMapping
    public List<ServiceKtx> getAll() {
        return serviceKtx.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceKtx getById(@PathVariable String id) {
        return serviceKtx.getServiceById(id).orElse(null);
    }

    @PostMapping
    public ServiceKtx create(@RequestBody ServiceKtx s) {
        return serviceKtx.saveService(s);
    }

    @PutMapping("/{id}")
    public ServiceKtx update(@PathVariable String id, @RequestBody ServiceKtx s) {
        s.setServiceID(id);
        return serviceKtx.saveService(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        serviceKtx.deleteService(id);
    }
}
