package com.example.Cua_Hang_Oto.controller;


import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping("/getAll")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createCar")
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/update/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        return carService.saveCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
//    @GetMapping("/filter")
//    public ResponseEntity<List<Car>> getFilteredCars(
//            @RequestParam(required = false) String brand,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false, defaultValue = "999999") double price) {
//
//        List<Car> cars = carService.getFilteredCars(brand, category, price);
//        return ResponseEntity.ok(cars);
//    }
}
