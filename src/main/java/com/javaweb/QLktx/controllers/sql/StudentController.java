package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.Student;
import com.javaweb.QLktx.services.sql.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return service.getStudentById(id).orElse(null);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        student.setStudentID(id);
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteStudent(id);
    }
}
