package com.KiranaStore.KiranaStore.model;

import lombok.AllArgsConstructor;
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
    private String currency;
    private LocalDateTime timeStamp;


    public Transaction(String id, String type, LocalDateTime timeStamp, float amount, String currency) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.timeStamp = timeStamp;


    }

}

