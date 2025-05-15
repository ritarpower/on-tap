package com.example.testcodem4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "giao_dich")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String type;

    private Double acreage;

    private Double price;

    public Transaction() {
    }

    public Transaction(LocalDate date, Customer customer, String type, Double acreage, Double price) {
        this.date = date;
        this.customer = customer;
        this.type = type;
        this.acreage = acreage;
        this.price = price;
    }

    public Transaction(int id, LocalDate date, Customer customer, String type, Double acreage, Double price) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.type = type;
        this.acreage = acreage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
