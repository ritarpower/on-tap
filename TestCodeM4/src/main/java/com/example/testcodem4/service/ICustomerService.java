package com.example.testcodem4.service;

import com.example.testcodem4.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    Customer findByName(String name);
}
