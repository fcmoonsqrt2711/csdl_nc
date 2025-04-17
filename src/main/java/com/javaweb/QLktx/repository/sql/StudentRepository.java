// src/main/java/com/example/ktx/repository/StudentRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
