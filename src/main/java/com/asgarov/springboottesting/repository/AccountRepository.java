package com.asgarov.springboottesting.repository;

import com.asgarov.springboottesting.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    void save(Account account);
}
