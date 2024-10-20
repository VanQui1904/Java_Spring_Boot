package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
//    List<Car> findByBrandAndCategoryAndPriceLessThanEqual(String brand, String category, double price);
}
