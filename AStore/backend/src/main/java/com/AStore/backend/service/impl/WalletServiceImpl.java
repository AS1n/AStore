package com.AStore.backend.service.impl;

import com.AStore.backend.model.TransBody;
import com.AStore.backend.model.Wallet;
import com.AStore.backend.repository.WalletRepository;
import com.AStore.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WalletServiceImpl implements WalletService {

    private final WalletRepository repository;

    @Autowired
    public WalletServiceImpl(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return repository.save(wallet);
    }

    @Override
    public Optional<Wallet> getWalletById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Wallet> getAllWallets() {
        return repository.findAll();
    }

    @Override
    public Page<Wallet> getPage(Integer page, Integer size, Long user_id) {
        Pageable pageable = new PageRequest(page-1, size, new Sort(Sort.Direction.ASC, "id"));
        if(user_id==null)
            return repository.findAll(pageable);
        return repository.findWalletsByUserId(pageable, user_id);
    }

    @Override
    public TransBody transaction(TransBody body) {
        increaseWallet(body.getTo(), body.getValue());
        if(body.getFrom()!=null)
            decreaseWallet(body.getFrom(), body.getValue());
        return body;
    }

    @Override
    public Iterable<Wallet> getWalletsByUserId(Long id) {
        return repository.findWalletsByUserId(id);
    }

    private void increaseWallet(Long id, Double value) {
        repository.increase(id, value);
    }

    private void decreaseWallet(Long id, Double value) {
        repository.decrease(id, value);
    }

    @Override
    public void deleteWallet(Long id) {
        repository.deleteById(id);
    }
}
