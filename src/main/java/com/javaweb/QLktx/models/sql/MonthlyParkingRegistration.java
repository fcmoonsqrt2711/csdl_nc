package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "MonthlyParkingRegistration", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyParkingRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    @Column(name = "licensePlate")
    private String licensePlate;
    @Column(name = "registrationDate")
    private LocalDate registrationDate;

    // Getters and setters
}
