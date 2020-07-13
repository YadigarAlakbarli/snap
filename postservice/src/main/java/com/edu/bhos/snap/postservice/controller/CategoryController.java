package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.ICategoryController;
import com.edu.bhos.snap.postservice.entity.Category;
import com.edu.bhos.snap.postservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category-service")
public class CategoryController implements ICategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<Category> getById(Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Override
    public ResponseEntity<String> addCategory(Category category) {
        categoryService.saveCategory(category);
        return ResponseEntity.ok("Category added succesfully");
    }

    @Override
    public ResponseEntity<Category> updateCategory(Category category) {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @Override
    public ResponseEntity<String> deleteCategoryById(Integer id) {
        String respons = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(respons);
    }
}
