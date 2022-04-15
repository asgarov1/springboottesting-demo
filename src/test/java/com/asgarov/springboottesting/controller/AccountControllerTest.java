package com.asgarov.springboottesting.controller;

import com.asgarov.springboottesting.domain.Account;
import com.asgarov.springboottesting.repository.AccountRepository;
import com.asgarov.springboottesting.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest({AccountController.class, AccountService.class})
class AccountControllerTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_homeResponseOK() throws Exception {
        // given we have an account
        Account account = new Account("1", "John", BigDecimal.ZERO);

        // and a mock repository that returns the account
        when(accountRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(account));

        // when we make a request to the account endpoint
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/account/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value(account.getName()))
                .andReturn()
                .getResponse().getContentAsString();

        // then we expect the response to be the account
        Account returnedAccount = new ObjectMapper().readValue(response, Account.class);
        assertEquals(account, returnedAccount);
    }
}