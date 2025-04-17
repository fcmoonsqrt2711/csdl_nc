// StudentService.java
package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {


    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(String id);

    public Student saveStudent(Student student);

    public void deleteStudent(String id);
}
