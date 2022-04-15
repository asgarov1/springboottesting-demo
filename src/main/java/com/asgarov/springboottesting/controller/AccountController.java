package com.asgarov.springboottesting.controller;

import com.asgarov.springboottesting.domain.Account;
import com.asgarov.springboottesting.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{accountId}")
    public Account getAccountInfo(String accountId) {
        return accountService.findById(accountId);
    }
}
