package com.KiranaStore.KiranaStore.service.Impl;


import com.KiranaStore.KiranaStore.Response.ExchangeRateResponse;
import com.KiranaStore.KiranaStore.model.Transaction;
import com.KiranaStore.KiranaStore.repository.TransactionRepository;
import com.KiranaStore.KiranaStore.service.ExternalApiService;
import com.KiranaStore.KiranaStore.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository myTrans;
    private final ExternalApiService externalApiService;

    public TransactionServiceImpl(TransactionRepository myTrans, ExternalApiService externalApiService) {
        super();
        this.myTrans = myTrans;
        this.externalApiService = externalApiService;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        String id = transaction.getId();
        String type = transaction.getType();
        float amount = transaction.getAmount();
        String currency = transaction.getCurrency();
        LocalDateTime timeStamp = LocalDateTime.now();

        ExchangeRateResponse response = externalApiService.fetchDataFromExternalApi();
        Map<String, Double> rates = response.getRates();
        Double exchangeValue = rates.get(currency);
        float currencyToDollar = (float) (amount/exchangeValue);
        System.out.println("currency converted to dollar value is " + currencyToDollar);
        Transaction request = new Transaction(id, type, timeStamp,amount, currency, currencyToDollar);
        return myTrans.save(request);
    }
}
