package com.restflux.restflux.invoice.infraestructure.repository;

import com.restflux.restflux.invoice.domain.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends ReactiveMongoRepository<Invoice,Integer> {
}
