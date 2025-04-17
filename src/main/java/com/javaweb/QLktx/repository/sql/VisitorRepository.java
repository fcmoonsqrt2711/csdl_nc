// VisitorRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.Dto.StudentVisitorDTO;
import com.javaweb.QLktx.models.sql.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, String> {

    @Query("SELECT StudentVisitorDTO(s.studentID, s.name, v.name, COUNT(v)) " +
            "FROM Visitor v JOIN v.student s " +
            "WHERE v.visitDate BETWEEN :start AND :end " +
            "GROUP BY s.studentID, s.name, v.name")
    List<StudentVisitorDTO> getVisitorsBetween(LocalDate start, LocalDate end);
}
