package com.AStore.backend.controller;

import com.AStore.backend.model.Subscription;
import com.AStore.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(
            @PathVariable(name = "id") Long id) {
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(id);
        if (subscription.isPresent()) {
            return ResponseEntity.ok(subscription.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping
    public Iterable<Subscription> getAllSubscriptions(
            @RequestParam(name = "user_id") Long userId) {
        return subscriptionService.getAllSubscriptions(userId);
    }

    @RequestMapping(value = "/products")
    public Iterable<Subscription> getProductsByUserId(
            @RequestParam(name = "page") Integer pageNumber,
            @RequestParam(name = "size") Integer size,
            @RequestParam(name = "user_id", required = false) Long userId) {
        Page page = subscriptionService.getSubscriptionsPageByUserId(pageNumber, size, userId);
        return page.getContent();
    }

    @RequestMapping(value = "/product")
    public ResponseEntity<Subscription> getSubscriptionByUserAndProductId(
            @RequestParam(name = "user_id") Long userId,
            @RequestParam(name = "product_id") Long productId) {
        Optional<Subscription> subscription = subscriptionService.getSubscriptionByUserAndProductId(userId, productId);
        return subscription.map(ResponseEntity::ok).orElse(null);
    }

    @RequestMapping(value = "/total-pages")
    public Integer getTotalPages(
            @RequestParam(name = "size") Integer size,
            @RequestParam(name = "user_id", required = false) Long user_id) {
        Page page = subscriptionService.getSubscriptionsPageByUserId(1, size, user_id);
        return page.getTotalPages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Subscription saveSubscription(
            @RequestBody Subscription account) {
        return subscriptionService.saveSubscription(account);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity unsubscribe(
            @RequestParam(name = "product_id") Long prodId,
            @RequestParam(name = "user_id") Long userId) {
        subscriptionService.unsubscribe(prodId, userId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubscription(@PathVariable(name = "id") Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }

}
