package com.campus.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.eventmanagement.model.Category;
import com.campus.eventmanagement.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category search(Long id) {

        Category category =
                categoryRepository.findById(id).orElse(null);

        return category;
    }

    @Override
    public Category update(Category category) {

        Category existingCategory =
                categoryRepository.findById(category.getId()).orElse(null);

        if (existingCategory != null) {

            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());

            return categoryRepository.save(existingCategory);
        }

        return null;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}