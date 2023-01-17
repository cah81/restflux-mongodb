package com.restflux.restflux.invoice.application;

import com.restflux.restflux.invoice.domain.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceServicePort {

    public Mono<Invoice> saveInvoice(Invoice invoice);

    public Flux<Invoice> findAllInvoices();

    public Mono<Invoice> getOneInvoice(Integer id);

    public Mono<Void> deleteInvoice(Integer id);
}
