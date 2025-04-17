package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Invoice", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;

    @Column(precision = 12, scale = 2, name = "totalAmount")
    private BigDecimal totalAmount;

    // Getters and setters
}
