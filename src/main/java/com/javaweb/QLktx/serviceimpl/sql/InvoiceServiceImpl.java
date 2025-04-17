package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.Invoice;
import com.javaweb.QLktx.repository.sql.InvoiceRepository;
import com.javaweb.QLktx.services.sql.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository repository;

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return repository.findById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return repository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        repository.deleteById(id);
    }
}
