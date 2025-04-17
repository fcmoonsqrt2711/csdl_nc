package com.javaweb.QLktx.models.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Room", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "roomNumber")
    private String roomNumber;

    @Column(name = "roomType")
    private String roomType;

    @Column(precision = 10, scale = 2, name = "price")
    private BigDecimal price;

    @Column(name = "maxOccupants")
    private int maxOccupants;

    // Getters and setters
}
