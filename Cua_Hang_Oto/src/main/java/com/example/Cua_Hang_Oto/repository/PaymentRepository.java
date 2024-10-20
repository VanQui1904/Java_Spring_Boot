package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
