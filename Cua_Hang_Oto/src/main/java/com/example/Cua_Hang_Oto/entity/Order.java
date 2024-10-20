package com.example.Cua_Hang_Oto.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="car_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;
    private BigDecimal car_price;
    private LocalDateTime order_date;
    private String status;

    public Order() {}

    public Order(Long customer_id,BigDecimal car_price, LocalDateTime order_date, String status) {
        this.customer_id = customer_id;
        this.car_price = car_price;
        this.order_date = order_date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCar_price() {
        return car_price;
    }

    public void setCar_price(BigDecimal car_price) {
        this.car_price = car_price;
    }
}
