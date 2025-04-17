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
@Table(name = "Service", schema = "ktx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceKtx {
    @Id
    @Column(name = "serviceID")
    private String serviceID;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(precision = 10, scale = 2, name = "unitPrice")
    private BigDecimal unitPrice;

    // Getters and setters
}
