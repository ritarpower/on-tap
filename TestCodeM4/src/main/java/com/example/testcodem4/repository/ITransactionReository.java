package com.example.testcodem4.repository;

import com.example.testcodem4.model.Customer;
import com.example.testcodem4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionReository extends JpaRepository<Transaction, Integer> {

//    @Query("SELECT t FROM Transaction t WHERE t.type = :type AND LOWER(t.customer.name) LIKE LOWER(CONCAT('%', :name, '%'))")
//    List<Transaction> findAllTransactionsByTypeAndCustomerName(@Param("type") String type, @Param("name") String name);
    @Query("SELECT t FROM Transaction t WHERE LOWER(t.customer.name) LIKE LOWER(CONCAT('%', :name, '%')) AND t.type = :type")
    List<Transaction> findAllTransactionsByTypeAndCustomerName(@Param("type") String type, @Param("name") String name);
}
