package com.example.testcodem4.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TransactionDTO {
    private int id;

    @NotNull(message = "Chọn tên khách hàng!")
    private Customer customer;

    @NotBlank(message = "Chọn loại giao dịch!")
    private String type;

    @NotNull(message = "Nhập ngày giao dịch!")
    @Future(message = "Ngày giao dịch phải sau ngày hiện tại!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @NotNull(message = "Nhập giá!")
    @Min(value = 500000, message = "Giá phải lớn hơn 500.000 VND")
    private Double price;

    @NotNull(message = "Nhập diện tích")
    @Min(value = 21, message = "Diện tích phải lớn hơn 20 m2")
    private Double acreage;

    public TransactionDTO() {
    }

    public TransactionDTO(Customer customer, String type, LocalDate date, Double price, Double acreage) {
        this.customer = customer;
        this.type = type;
        this.date = date;
        this.price = price;
        this.acreage = acreage;
    }

    public TransactionDTO(int id, Customer customer, String type, LocalDate date, Double price, Double acreage) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.date = date;
        this.price = price;
        this.acreage = acreage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }
}
