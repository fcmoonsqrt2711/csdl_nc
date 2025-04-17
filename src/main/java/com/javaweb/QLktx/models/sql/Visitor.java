package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Visitor", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    @Id
    @Column(name = "VisitorID")
    private String visitorID;

    @Column(name = "NationalID")
    private String nationalID;

    @Column(name = "name")
    private String name;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "visitDate")
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    // Getters and setters
}
