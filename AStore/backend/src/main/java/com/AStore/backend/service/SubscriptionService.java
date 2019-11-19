package com.AStore.backend.service;

import com.AStore.backend.model.Subscription;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SubscriptionService {
    Subscription saveSubscription(Subscription category);
    Optional<Subscription> getSubscriptionById(Long id);
    Page<Subscription> getSubscriptionsPageByUserId(Integer page, Integer size, Long userId);
    Optional<Subscription> getSubscriptionByUserAndProductId(Long userId, Long productId);
    Iterable<Subscription> getAllSubscriptions(Long userId);
    Double calculatePrice(Subscription subscription);
    void unsubscribe(Long prodId, Long userId);
    void deleteSubscription(Long id);
}
