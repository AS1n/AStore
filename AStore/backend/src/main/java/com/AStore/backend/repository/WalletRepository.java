package com.AStore.backend.repository;

import com.AStore.backend.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends
        CrudRepository<Wallet, Long>,
        PagingAndSortingRepository<Wallet, Long> {
    List<Wallet> findWalletsByUserId(Long id);
    Page<Wallet> findWalletsByUserId(Pageable pageable, Long id);

    @Modifying
    @Query("update Wallet w set w.value = w.value + :amount where w.id = :id")
    void increase(@Param("id") Long id, @Param("amount") Double amount);

    @Modifying
    @Query("update Wallet w set w.value = w.value - :amount where w.id = :id")
    void decrease(@Param("id") Long id, @Param("amount") Double amount);
}
