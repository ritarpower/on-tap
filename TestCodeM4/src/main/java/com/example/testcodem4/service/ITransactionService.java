package com.example.testcodem4.service;

import com.example.testcodem4.model.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
