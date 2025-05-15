package com.example.testcodem4.repository;

import com.example.testcodem4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByName(String name);
}
