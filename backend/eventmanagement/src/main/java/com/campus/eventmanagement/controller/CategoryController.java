package com.campus.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campus.eventmanagement.model.Category;
import com.campus.eventmanagement.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
            @PathVariable Long id) {

        Category category = categoryService.search(id);

        if (category != null) {
            return ResponseEntity.ok(category);
        }

        return ResponseEntity.notFound().build();
    }

    // Add category
    @PostMapping
    public Category addCategory(
            @RequestBody Category category) {

        return categoryService.insert(category);
    }

    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody Category category) {

        category.setId(id);

        Category updatedCategory =
                categoryService.update(category);

        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        }

        return ResponseEntity.notFound().build();
    }
}