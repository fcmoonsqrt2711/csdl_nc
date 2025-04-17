package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Student, String> {

    @Query(value = """
        SELECT 
            StudentID,
            Month,
            Year,
            SUM(TotalAmount) AS MonthlyTotal
        FROM (
            SELECT 
                ssu.StudentID,
                MONTH(ssu.UsageTime) AS Month,
                YEAR(ssu.UsageTime) AS Year,
                SUM(s.UnitPrice) AS TotalAmount
            FROM studentserviceusage ssu
            JOIN service s ON ssu.ServiceID = s.ServiceID
            GROUP BY ssu.StudentID, YEAR(ssu.UsageTime), MONTH(ssu.UsageTime)

            UNION ALL

            SELECT 
                st.studentID AS StudentID,
                MONTH(CURDATE()) AS Month,
                YEAR(CURDATE()) AS Year,
                r.Price AS TotalAmount
            FROM student st
            JOIN room r ON st.roomID = r.RoomNumber

            UNION ALL

            SELECT 
                mpr.StudentID,
                MONTH(vio.TimeIn) AS Month,
                YEAR(vio.TimeIn) AS Year,
                SUM(vio.Fee) AS TotalAmount
            FROM vehicleinout vio
            JOIN monthlyparkingregistration mpr ON vio.RegistrationID = mpr.ID
            GROUP BY mpr.StudentID, YEAR(vio.TimeIn), MONTH(vio.TimeIn)
        ) AS CombinedCosts
        GROUP BY StudentID, Month, Year
        ORDER BY Year, Month, StudentID
        """, nativeQuery = true)
    List<Object[]> getMonthlyStudentExpenses();

    @Query(value = """
        SELECT 
            s.studentID, 
            s.name, 
            r.RoomNumber, 
            r.Price AS MonthlyRoomFee, 
            COALESCE(service_revenue.TotalServiceRevenue, 0) AS TotalServiceRevenue, 
            COALESCE(parking_fee.TotalParkingFee, 0) AS TotalParkingFee, 
            r.Price + COALESCE(service_revenue.TotalServiceRevenue, 0) + COALESCE(parking_fee.TotalParkingFee, 0) AS TotalRevenue 
        FROM student s 
        JOIN room r ON s.roomID = r.RoomNumber 
        LEFT JOIN ( 
            SELECT 
                ssu.StudentID, 
                SUM(sv.UnitPrice) AS TotalServiceRevenue 
            FROM studentserviceusage ssu 
            JOIN service sv ON ssu.ServiceID = sv.ServiceID 
            GROUP BY ssu.StudentID 
        ) AS service_revenue ON s.studentID = service_revenue.StudentID 
        LEFT JOIN ( 
            SELECT 
                mpr.StudentID, 
                SUM(vio.Fee) AS TotalParkingFee 
            FROM monthlyparkingregistration mpr 
            LEFT JOIN vehicleinout vio ON mpr.ID = vio.RegistrationID 
            GROUP BY mpr.StudentID 
        ) AS parking_fee ON s.studentID = parking_fee.StudentID;
        """, nativeQuery = true)
    List<Object[]> getStudentRevenueReport();
}
