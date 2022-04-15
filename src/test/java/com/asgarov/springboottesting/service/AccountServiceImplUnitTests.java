package com.asgarov.springboottesting.service;

import com.asgarov.springboottesting.domain.Account;
import com.asgarov.springboottesting.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplUnitTests {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;
//    AccountService accountService = new AccountServiceImpl(Mockito.mock(AccountRepository.class));

    @Test
    @DisplayName("deposit funktion sollte den Account balance auf die richtige Summe erhöhen")
    public void test_depositHappyPath() {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100));
        accountService.deposit(account, BigDecimal.valueOf(100));
        assertEquals(200, account.getBalance().intValue());
    }
}