package com.example.Cua_Hang_Oto.entity;

import jakarta.persistence.*;

@Entity
@Table(name="showrooms")
public class Showroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String showroom_name;
    private String address;
    public Showroom() {}
    public Showroom(String showroom_name, String address) {
        this.address = address;
        this.showroom_name = showroom_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShowroom_name() {
        return showroom_name;
    }

    public void setShowroom_name(String showroom_name) {
        this.showroom_name = showroom_name;
    }
}
