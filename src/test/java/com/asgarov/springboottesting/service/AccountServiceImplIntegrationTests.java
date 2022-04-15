package com.asgarov.springboottesting.service;

import com.asgarov.springboottesting.domain.Account;
import com.asgarov.springboottesting.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AccountServiceImpl.class)
public class AccountServiceImplIntegrationTests {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("deposit funktion sollte den Account balance auf die richtige Summe erhöhen")
    public void test_depositHappyPath() {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100));
        accountService.deposit(account, BigDecimal.valueOf(100));
        assertEquals(200, account.getBalance().intValue());
    }
}