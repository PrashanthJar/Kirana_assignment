package com.KiranaStore.KiranaStore.repository;

import com.KiranaStore.KiranaStore.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByTimeStampBetween(LocalDateTime start, LocalDateTime end);
}

