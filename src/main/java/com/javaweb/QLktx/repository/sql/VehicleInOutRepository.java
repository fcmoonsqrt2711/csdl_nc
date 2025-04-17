// VehicleInOutRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.VehicleInOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleInOutRepository extends JpaRepository<VehicleInOut, Long> {
}
