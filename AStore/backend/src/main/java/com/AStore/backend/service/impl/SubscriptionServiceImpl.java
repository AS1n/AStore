package com.AStore.backend.service.impl;

import com.AStore.backend.model.Subscription;
import com.AStore.backend.repository.SubscriptionRepository;
import com.AStore.backend.service.SubscriptionService;
import com.AStore.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final WalletService walletService;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository, WalletService walletService) {
        this.repository = repository;
        this.walletService = walletService;
    }

    @Override
    public Optional<Subscription> getSubscriptionById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Subscription> getSubscriptionsPageByUserId(Integer page, Integer size, Long userId) {
        Pageable pageable = new PageRequest(page-1, size, new Sort(Sort.Direction.ASC, "id"));
        if(userId==null)
            return repository.findAll(pageable);
        return repository.findSubscriptionsByUserWalletUserId(pageable, userId);
    }

    @Override
    public Optional<Subscription> getSubscriptionByUserAndProductId(Long userId, Long productId) {
        return repository.findSubscriptionsByUserWalletUserIdAndProductId(userId, productId);
    }

    @Override
    public Iterable<Subscription> getAllSubscriptions(Long userId) {
        if(userId == null)
            return repository.findAll();
        return repository.findSubscriptionsByUserWalletUserId(userId);
    }

    @Override
    public Double calculatePrice(Subscription subscription) {
        Double fullPrice = subscription.getProduct().getCost();
        return fullPrice/30;
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        Long userId = walletService.getWalletById(subscription.getUserWallet().getId()).get().getUser().getId();
        Optional<Subscription> sub = repository.findSubscriptionsByUserWalletUserIdAndProductId(userId, subscription.getProduct().getId());
        if(subscription.getId()==null && sub.isPresent())
            return null;
        return repository.save(subscription);
    }

    @Override
    public void unsubscribe(Long prodId, Long userId) {
        Optional<Subscription> subscription = repository.findSubscriptionsByUserWalletUserIdAndProductId(userId, prodId);
        subscription.ifPresent(subscription1 -> repository.deleteById(subscription1.getId()));
    }

    @Override
    public void deleteSubscription(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
    }
}
