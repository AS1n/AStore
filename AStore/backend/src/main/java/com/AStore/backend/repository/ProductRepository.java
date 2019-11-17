package com.AStore.backend.repository;

import com.AStore.backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends
        CrudRepository<Product, Long>,
        PagingAndSortingRepository<Product, Long> {
    Page<Product> findProductsByCategoryId(Pageable pageable, Long id);
    Page<Product> findProductsByWalletUserId(Pageable pageable, Long userId);
    Optional<Product> findProductByName(String name);
}
