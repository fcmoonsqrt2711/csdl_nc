package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.StudentServiceUsage;
import com.javaweb.QLktx.repository.sql.StudentServiceUsageRepository;
import com.javaweb.QLktx.services.sql.StudentServiceUsageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceUsageServiceImpl implements StudentServiceUsageService {
    private final StudentServiceUsageRepository repository;

    public StudentServiceUsageServiceImpl(StudentServiceUsageRepository repository) {
        this.repository = repository;
    }

    public List<StudentServiceUsage> getAllUsages() {
        return repository.findAll();
    }

    public Optional<StudentServiceUsage> getUsageById(Long id) {
        return repository.findById(id);
    }

    public StudentServiceUsage saveUsage(StudentServiceUsage usage) {
        return repository.save(usage);
    }

    public void deleteUsage(Long id) {
        repository.deleteById(id);
    }
}
