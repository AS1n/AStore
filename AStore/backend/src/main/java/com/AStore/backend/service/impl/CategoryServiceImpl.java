package com.AStore.backend.service.impl;

import com.AStore.backend.model.Category;
import com.AStore.backend.repository.CategoryRepository;
import com.AStore.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
