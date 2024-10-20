package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
