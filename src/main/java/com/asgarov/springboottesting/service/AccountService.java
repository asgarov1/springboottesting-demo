package com.asgarov.springboottesting.service;

import com.asgarov.springboottesting.domain.Account;

import java.math.BigDecimal;

public interface AccountService {
    void deposit(Account account, BigDecimal amount);

    Account findById(String accountId);
}
