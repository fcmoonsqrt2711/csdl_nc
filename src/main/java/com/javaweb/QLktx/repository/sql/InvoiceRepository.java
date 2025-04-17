// InvoiceRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.Dto.StudentMonthlyPaymentDTO;
import com.javaweb.QLktx.models.sql.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT StudentMonthlyPaymentDTO(" +
            "i.student.studentID, i.student.name, i.month, i.year, SUM(i.totalAmount)) " +
            "FROM Invoice i " +
            "GROUP BY i.student.studentID, i.student.name, i.month, i.year")
    List<StudentMonthlyPaymentDTO> getStudentMonthlyPayments();


}
