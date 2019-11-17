package com.AStore.backend.repository;

import com.AStore.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        CrudRepository<User, Long>,
        PagingAndSortingRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}
