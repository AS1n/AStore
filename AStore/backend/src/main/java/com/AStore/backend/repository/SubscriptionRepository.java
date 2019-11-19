package com.AStore.backend.repository;

import com.AStore.backend.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends
        CrudRepository<Subscription, Long>,
        PagingAndSortingRepository<Subscription, Long> {
    Iterable<Subscription> findSubscriptionsByUserWalletUserId(Long userId);
    Optional<Subscription> findSubscriptionsByUserWalletUserIdAndProductId(Long userId, Long productId);
    Page<Subscription> findSubscriptionsByUserWalletUserId(Pageable pageable, Long id);
}
