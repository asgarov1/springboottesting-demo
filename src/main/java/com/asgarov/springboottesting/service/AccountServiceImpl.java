package com.asgarov.springboottesting.service;

import com.asgarov.springboottesting.domain.Account;
import com.asgarov.springboottesting.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    @Override
    public Account findById(String accountId) {
        return accountRepository.findById(accountId).orElseThrow();
    }
}
