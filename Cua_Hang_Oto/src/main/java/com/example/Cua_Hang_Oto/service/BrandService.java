package com.example.Cua_Hang_Oto.service;

import com.example.Cua_Hang_Oto.entity.Brand;
import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.repository.BrandRepository;
import com.example.Cua_Hang_Oto.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;



    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
