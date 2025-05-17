package com.example.testcodem4.service;

import com.example.testcodem4.model.Customer;
import com.example.testcodem4.model.Transaction;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
    Transaction findTransactionById(int id);
    void deleteTransactionById(int id);
    List<Transaction> findTransactionByTypeAndCustomerName(String type, String name);
//    List<Transaction> findAllTransactionsByTypeAndCustomerId(String type,Customer customer);
}
