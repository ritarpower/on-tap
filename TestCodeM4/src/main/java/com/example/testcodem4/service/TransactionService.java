package com.example.testcodem4.service;

import com.example.testcodem4.model.Customer;
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

    @Override
    public Transaction findTransactionById(int id) {
        return transactionReository.findById(id).orElse(null);
    }

    @Override
    public void deleteTransactionById(int id) {
        transactionReository.deleteById(id);
    }

//    @Override
//    public List<Transaction> findAllTransactionsByTypeAndCustomerId(String type, Customer customer) {
//        return transactionReository.findAllTransactionsByTypeAndCustomerId(type, customer);
//    }

    @Override
    public List<Transaction> findTransactionByTypeAndCustomerName(String type, String name) {
        return transactionReository.findAllTransactionsByTypeAndCustomerName(type, name);
    }
}
