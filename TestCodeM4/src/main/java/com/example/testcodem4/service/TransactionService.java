package com.example.testcodem4.service;

import com.example.testcodem4.model.Transaction;
import com.example.testcodem4.repository.ITransactionReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionReository transactionReository;

    @Override
    public List<Transaction> getTransactions() {
        return transactionReository.findAll();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionReository.save(transaction);
    }
}
