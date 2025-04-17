package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.ServiceKtx;
import com.javaweb.QLktx.repository.sql.ServiceKtxRepository;
import com.javaweb.QLktx.services.sql.ServiceKtxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceKtxServiceImpl implements ServiceKtxService {
    private final ServiceKtxRepository repository;

    public ServiceKtxServiceImpl(ServiceKtxRepository repository) {
        this.repository = repository;
    }

    public List<ServiceKtx> getAllServices() {
        return repository.findAll();
    }

    public Optional<ServiceKtx> getServiceById(String id) {
        return repository.findById(id);
    }

    public ServiceKtx saveService(ServiceKtx serviceKtx) {
        return repository.save(serviceKtx);
    }

    public void deleteService(String id) {
        repository.deleteById(id);
    }
}
