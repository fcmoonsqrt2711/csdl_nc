package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.StudentServiceUsage;

import java.util.List;
import java.util.Optional;

public interface StudentServiceUsageService {

    public List<StudentServiceUsage> getAllUsages();

    public Optional<StudentServiceUsage> getUsageById(Long id);

    public StudentServiceUsage saveUsage(StudentServiceUsage usage);

    public void deleteUsage(Long id);
}
