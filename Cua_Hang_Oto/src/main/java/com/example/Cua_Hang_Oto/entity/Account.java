package com.example.Cua_Hang_Oto.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long customer_id;

    @Column(nullable = false)
    private String username;


    @Column(name="account_password",nullable = false)
    private String accountPassword;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String account_role;

    @Column(nullable = false)
    private LocalDateTime created_at;

    public Account() {}

    public Account(Long customer_id, String username, String accountPassword, String email, String account_role, LocalDateTime created_at) {
        this.customer_id = customer_id;
        this.username = username;
        this.accountPassword = accountPassword;
        this.email = email;
        this.account_role = account_role;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String account_password) {
        this.accountPassword = account_password;
    }

    public String getAccount_role() {
        return account_role;
    }

    public void setAccount_role(String account_role) {
        this.account_role = account_role;
    }


    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
