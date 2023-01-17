package com.restflux.restflux.invoice.domain;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Data
@Document(collection = "invoice")
public class Invoice {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Integer id;
    private String name;
    private String number;
    private Double amount;
}
