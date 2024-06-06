package com.spring.rest.springrest.service;

import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.entities.Account;

import java.util.List;

public interface AccountService {
    void createAccount(AccountDTO accountDTO) ;
    List<Account> getAllAccounts();
    Account getAccount(Integer account);
    Account updateAccount(Account account, Integer accountId);
    void deleteAccount(Integer accountId);

}
