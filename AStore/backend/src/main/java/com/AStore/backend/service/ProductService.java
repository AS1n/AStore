package com.AStore.backend.service;

import com.AStore.backend.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product user);
    Optional<Product> getProductById(Long id);
    void deleteProduct(Long id);
    Page<Product> getPage(Integer page, Integer size, Long category_id);
    Page<Product> getOwnPage(Integer page, Integer size, Long manager_id);
}
