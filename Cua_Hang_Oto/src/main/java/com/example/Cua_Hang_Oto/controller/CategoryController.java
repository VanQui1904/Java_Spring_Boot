package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Category;
import com.example.Cua_Hang_Oto.repository.CategoryRepository;
import com.example.Cua_Hang_Oto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/getAll")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Category> getCategoryById(long id){
        Optional<Category> category = categoryService.getCateById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createCate")
    public Category createCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping("/update/{id}")
     public Category updateCategory(@RequestBody Category category, @PathVariable Long id){
        category.setId(id);
        return categoryService.saveCategory(category);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
