package com.example.Cua_Hang_Oto.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="testdrives")
public class TestDrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long customer_id;
    private int car_id;
    private int showroom_id;
    private LocalDateTime bookingTime;
    private String status;

    public TestDrive() {}

    public TestDrive(Long customer_id, int car_id, int showroom_id, LocalDateTime bookingTime, String status) {
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.showroom_id = showroom_id;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getShowroom_id() {
        return showroom_id;
    }

    public void setShowroom_id(int showroom_id) {
        this.showroom_id = showroom_id;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
