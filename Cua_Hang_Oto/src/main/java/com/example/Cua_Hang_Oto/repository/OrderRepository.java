package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
