package com.example.Cua_Hang_Oto.service;

import com.example.Cua_Hang_Oto.entity.Brand;
import com.example.Cua_Hang_Oto.entity.Category;
import com.example.Cua_Hang_Oto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCateById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category brand) {
        return categoryRepository.save(brand);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
