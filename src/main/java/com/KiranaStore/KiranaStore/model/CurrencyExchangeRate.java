package com.KiranaStore.KiranaStore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "currency_exchange_rates")
public class CurrencyExchangeRate {

    @Id
    private String currency;
    private double rate;

}


