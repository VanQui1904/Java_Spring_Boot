package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Brand;
import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/getAll")
    public List<Brand> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/getBrandById/{id}")
    public ResponseEntity<Brand> getCarById(@PathVariable Long id) {
        Optional<Brand> car = brandService.getBrandById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createBrand")
    public Brand createCar(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
    }

    @PutMapping("/update/{id}")
    public Brand updateCar(@PathVariable Long id, @RequestBody Brand brand) {
        brand.setId(id);
        return brandService.saveBrand(brand);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}
