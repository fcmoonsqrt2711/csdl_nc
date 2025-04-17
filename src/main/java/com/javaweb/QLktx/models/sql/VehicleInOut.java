package com.javaweb.QLktx.models.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "VehicleInOut", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registrationID")
    private MonthlyParkingRegistration registration;

    @Column(name = "timeIn")
    private LocalDateTime timeIn;
    @Column(name = "timeOut")
    private LocalDateTime timeOut;

    @Column(precision = 10, scale = 2, name = "fee")
    private BigDecimal fee;

    // Getters and setters
}
