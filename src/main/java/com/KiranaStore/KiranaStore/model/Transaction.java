package com.KiranaStore.KiranaStore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "transactions")
public class Transaction {
    // Getters and setters
    @Id
    private String id;
    private double amount;
    private String currency;


    public Transaction(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

}

