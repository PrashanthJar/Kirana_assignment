package com.KiranaStore.KiranaStore.repository;

import com.KiranaStore.KiranaStore.model.CurrencyExchangeRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRateRepository extends MongoRepository<CurrencyExchangeRate, String> {
    CurrencyExchangeRate findByCurrency(String currency);
}

