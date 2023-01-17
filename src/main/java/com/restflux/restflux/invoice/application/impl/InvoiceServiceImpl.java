package com.restflux.restflux.invoice.application.impl;

import com.restflux.restflux.generator.SequenceGeneratorService;
import com.restflux.restflux.invoice.application.InvoiceServicePort;
import com.restflux.restflux.invoice.domain.Invoice;
import com.restflux.restflux.invoice.infraestructure.repository.InvoiceRepository;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.restflux.restflux.invoice.domain.Invoice.SEQUENCE_NAME;
@Service
public class InvoiceServiceImpl implements InvoiceServicePort {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SequenceGeneratorService service;


    @Override
    public Mono<Invoice> saveInvoice(Invoice invoice) {
        invoice.setId(service.getSequenceNumber(SEQUENCE_NAME));
        return invoiceRepository.save(invoice);
    }

    @Override
    public Flux<Invoice> findAllInvoices() {
        return invoiceRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Invoice> getOneInvoice(Integer id) {
        return invoiceRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> deleteInvoice(Integer id) {
        return invoiceRepository.deleteById(id);
    }
}
