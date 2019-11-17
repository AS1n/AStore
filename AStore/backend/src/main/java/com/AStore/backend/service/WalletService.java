package com.AStore.backend.service;

import com.AStore.backend.model.TransBody;
import com.AStore.backend.model.Wallet;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface WalletService {
    Wallet saveWallet(Wallet wallet);
    Optional<Wallet> getWalletById(Long id);
    Iterable<Wallet> getWalletsByUserId(Long id);
    Iterable<Wallet> getAllWallets();
    Page<Wallet> getPage(Integer page, Integer size, Long user_id);
    TransBody transaction(TransBody body);
    void deleteWallet(Long id);
}
