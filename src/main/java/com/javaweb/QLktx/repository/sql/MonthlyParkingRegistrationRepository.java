// MonthlyParkingRegistrationRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.MonthlyParkingRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonthlyParkingRegistrationRepository extends JpaRepository<MonthlyParkingRegistration, Long> {
    @Query("SELECT p.student.studentID, COUNT(p.licensePlate) " +
            "FROM MonthlyParkingRegistration p " +
            "GROUP BY p.student.studentID " +
            "HAVING COUNT(p.licensePlate) > 2")
    List<Object[]> getStudentsOverVehicleLimit();
}
