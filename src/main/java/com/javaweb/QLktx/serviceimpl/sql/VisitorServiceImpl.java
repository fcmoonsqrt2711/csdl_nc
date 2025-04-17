package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.Visitor;
import com.javaweb.QLktx.repository.sql.VisitorRepository;
import com.javaweb.QLktx.services.sql.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository repository;

    public VisitorServiceImpl(VisitorRepository repository) {
        this.repository = repository;
    }

    public List<Visitor> getAllVisitors() {
        return repository.findAll();
    }

    public Optional<Visitor> getVisitorByNationalId(String nationalId) {
        return repository.findById(nationalId);
    }

    public Visitor saveVisitor(Visitor visitor) {
        return repository.save(visitor);
    }

    public void deleteVisitor(String nationalId) {
        repository.deleteById(nationalId);
    }
}
