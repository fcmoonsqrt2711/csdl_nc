package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.Invoice;
import com.javaweb.QLktx.services.sql.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Invoice> getAll() {
        return service.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return service.getInvoiceById(id).orElse(null);
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return service.saveInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice update(@PathVariable Long id, @RequestBody Invoice invoice) {
        invoice.setId(id);
        return service.saveInvoice(invoice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteInvoice(id);
    }
}
