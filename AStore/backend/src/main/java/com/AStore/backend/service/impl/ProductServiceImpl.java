package com.AStore.backend.service.impl;

import com.AStore.backend.model.Product;
import com.AStore.backend.repository.ProductRepository;
import com.AStore.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() == null && repository.findProductByName(product.getName()).isPresent())
            return null;
        return repository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Product> getPage(Integer page, Integer size, Long category_id) {
        Pageable pageable = new PageRequest(page - 1, size, new Sort(Sort.Direction.ASC, "id"));
        if (category_id == null)
            return repository.findAll(pageable);
        return repository.findProductsByCategoryId(pageable, category_id);
    }

    @Override
    public Page<Product> getOwnPage(Integer page, Integer size, Long manager_id) {
        Pageable pageable = new PageRequest(page - 1, size, new Sort(Sort.Direction.ASC, "id"));
        return repository.findProductsByWalletUserId(pageable, manager_id);
    }

}
