package com.KiranaStore.KiranaStore.repository;

import com.KiranaStore.KiranaStore.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}

