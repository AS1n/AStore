package com.AStore.backend.scheduler;

import com.AStore.backend.model.*;
import com.AStore.backend.service.SubscriptionService;
import com.AStore.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ScheduleTask {

    private final SubscriptionService subscriptionService;
    private final WalletService walletService;

    @Autowired
    public ScheduleTask(SubscriptionService subscriptionService, WalletService walletService) {
        this.subscriptionService = subscriptionService;
        this.walletService = walletService;
    }

    //(seconds, minutes, hours, day of month, month, day of week, year(optional))

    @Scheduled(cron = "0 */1 * * * ?")
    public void cronSchedule() {
        System.out.println("Date of transaction:" + new Date());
        Iterable<Subscription> subscriptions = subscriptionService.getAllSubscriptions(null);
        subscriptions.forEach(subscription -> transaction(subscription, walletService));
    }

    private void transaction(Subscription subscription, WalletService walletService) {
        Double price = subscriptionService.calculatePrice(subscription);
        Wallet userWallet = subscription.getUserWallet();
        Wallet wallet = subscription.getWallet();
        if (subscription.getActive() && (userWallet.getValue() - price <= 0 || !checkDateOfSubscr(subscription))) {
            subscription.setActive(false);
            subscriptionService.saveSubscription(subscription);
        } else if(!subscription.getActive() && userWallet.getValue() - price >= 0 && checkDateOfSubscr(subscription)){
            subscription.setActive(true);
            subscriptionService.saveSubscription(subscription);
        }
        if (subscription.getActive()) {
            walletService.transaction(userWallet.getId(), wallet.getId(), price);
            System.out.println("The wallet of user " + userWallet.getUser().getUsername() + " had decreased by " + price + "$ by product purchase");
            System.out.println("The wallet of content manager " + wallet.getUser().getUsername() + " had increased by " + price + "$ by product sale");
        }
    }

    private static Boolean checkDateOfSubscr(Subscription subscription) {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = subscription.getEnd().toLocalDate();
        LocalDate startDate = subscription.getStart().toLocalDate();
        return (currentDate.isAfter(startDate)||currentDate.isEqual(startDate)) && currentDate.isBefore(endDate);
    }

}
