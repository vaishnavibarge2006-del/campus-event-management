package com.campus.eventmanagement.service;

import java.util.List;

import com.campus.eventmanagement.model.Category;

public interface CategoryService {

    Category insert(Category category);

    Category search(Long id);

    Category update(Category category);

    List<Category> getAll();
}