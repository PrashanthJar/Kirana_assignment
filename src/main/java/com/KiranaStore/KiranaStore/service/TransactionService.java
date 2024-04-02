package com.KiranaStore.KiranaStore.service;

import com.KiranaStore.KiranaStore.model.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

}
