package com.example.Cua_Hang_Oto.service;


import com.example.Cua_Hang_Oto.entity.Brand;
import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Category;
import com.example.Cua_Hang_Oto.repository.BrandRepository;
import com.example.Cua_Hang_Oto.repository.CarRepository;
import com.example.Cua_Hang_Oto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
//        Optional<Brand> brandOptional = brandRepository.findById(car.getId());
//        if (!brandOptional.isPresent()) {
//            throw new RuntimeException("Brand not found with id: " + car.getId());
//        }
//
//        // Kiểm tra xem category có tồn tại không
//        Optional<Category> categoryOptional = categoryRepository.findById(car.getId());
//        if (!categoryOptional.isPresent()) {
//            throw new RuntimeException("Category not found with id: " + car.getId());
//        }
//        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
//    public List<Car> getFilteredCars(String brand, String category, double maxPrice) {
//        return carRepository.findByBrandAndCategoryAndPriceLessThanEqual(brand, category, maxPrice);
//    }

}
