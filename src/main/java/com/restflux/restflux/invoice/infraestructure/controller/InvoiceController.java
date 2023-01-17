package com.restflux.restflux.invoice.infraestructure.controller;

import com.restflux.restflux.invoice.application.InvoiceServicePort;
import com.restflux.restflux.invoice.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServicePort service;

    @PostMapping("/save")
    public Mono<Invoice> saveOneInvoice(@RequestBody Invoice invoice){
        return service.saveInvoice(invoice);
    }
    @GetMapping("/allInvoices")
    public Flux<Invoice> getAllInvoices(){
        return service.findAllInvoices();

    }
    @GetMapping("/get/{id}")
    public Mono<Invoice> getOneInvoice(@PathVariable Integer id){
        return service.getOneInvoice(id);

    }

    @DeleteMapping("/delete/{id}")
    public Mono<String> deleteInvoice(@PathVariable Integer id){
        service.deleteInvoice(id);
        return Mono.just("Invoice with id " + id + "deleted ! ");
    }

}
