package com.KiranaStore.KiranaStore.service;

import com.KiranaStore.KiranaStore.model.Transaction;
import com.KiranaStore.KiranaStore.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // Add a new transaction
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get a transaction by ID
    public Transaction getTransactionById(String id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        return optionalTransaction.orElse(null);
    }

    // Update a transaction
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Delete a transaction by ID
    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }
}
