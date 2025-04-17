package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Student", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "nationalID", unique = true)
    private String nationalID;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "name")
    private String name;

    @Column(name = "className")
    private String className;

    @Column(name = "hometown")
    private String hometown;

    // Mối quan hệ với Room: Một sinh viên chỉ thuộc một phòng.
    @ManyToOne
    @JoinColumn(name = "roomID")
    private Room room;

    // Mối quan hệ với StudentServiceUsage: Một sinh viên có thể sử dụng nhiều dịch vụ.
    @OneToMany(mappedBy = "student")
    private List<StudentServiceUsage> studentServiceUsages;

    // Mối quan hệ với Visitor: Một sinh viên có thể có nhiều khách đến thăm.
    @OneToMany(mappedBy = "student")
    private List<Visitor> visitors;
    // Getters and setters
}
