package com.example.testcodem4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transaction;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String email, List<Transaction> transaction) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.transaction = transaction;
    }

    public Customer(int id, String name, String phoneNumber, String email, List<Transaction> transaction) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
