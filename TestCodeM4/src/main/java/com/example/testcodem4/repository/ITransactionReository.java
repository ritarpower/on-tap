package com.example.testcodem4.repository;

import com.example.testcodem4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionReository extends JpaRepository<Transaction, Integer> {
}
