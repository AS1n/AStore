package com.AStore.backend.service;

import com.AStore.backend.model.Category;

import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Iterable<Category> getAllCategories();
    void deleteCategory(Long id);
}
