package com.KiranaStore.KiranaStore.controller;

import com.KiranaStore.KiranaStore.model.Transaction;
import com.KiranaStore.KiranaStore.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        super();
        this.transactionService = transactionService;
    }


    // Endpoint to add a new transaction
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

}
