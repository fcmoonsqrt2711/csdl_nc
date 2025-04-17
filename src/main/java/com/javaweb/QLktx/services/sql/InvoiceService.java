package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAllInvoices();

    Optional<Invoice> getInvoiceById(Long id);

    Invoice saveInvoice(Invoice invoice);

    void deleteInvoice(Long id);
}
