// StudentService.java
package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.Student;
import com.javaweb.QLktx.repository.sql.StudentRepository;
import com.javaweb.QLktx.services.sql.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return repository.findById(id);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(String id) {
        repository.deleteById(id);
    }
}
