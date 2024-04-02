package com.KiranaStore.KiranaStore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document(collection = "transactions")
public class Transaction {
    // Getters and setters
    @Id
    private String id;
    private String type;
    private float amount;
    private LocalDateTime timeStamp;
    private String currency;
    private float amountToDollar;

    public Transaction(String id, String type, float amount, LocalDateTime timeStamp, String currency, float amountToDollar) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.currency = currency;
        this.amountToDollar = amountToDollar;
    }
}

