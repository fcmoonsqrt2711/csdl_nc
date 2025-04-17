package com.javaweb.QLktx.models.noSql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vehicle_in_out_logs")
public class VehicleInOutLog {

    @Id
    private String id;

    private String licensePlate;
    private String studentId;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private Double fee;

    // Constructors, getters, setters
}