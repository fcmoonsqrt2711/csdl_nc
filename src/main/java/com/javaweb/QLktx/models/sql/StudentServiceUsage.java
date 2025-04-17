package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "StudentServiceUsage", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "serviceID")
    private ServiceKtx serviceKtx;

    @Column(name = "usageTime")
    private LocalDateTime usageTime;

    // Getters and setters
}
