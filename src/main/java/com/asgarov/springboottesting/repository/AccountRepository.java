package com.asgarov.springboottesting.repository;

import com.asgarov.springboottesting.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository {
    void save(Account account);

    Optional<Account> findById(String accountId);
}
