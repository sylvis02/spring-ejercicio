package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.entities.Account;
import com.spring.rest.springrest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/v1")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccounts(@PathVariable("accountId") Integer accountId){
        return new ResponseEntity<Account>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @PostMapping(value = "/createAccount", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createAccount(@RequestBody AccountDTO account)  {
        accountService.createAccount(account);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer accountId){
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{accountId}", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,
                                                 @PathVariable Integer accountId){
        return new ResponseEntity<Account>(accountService.updateAccount(account, accountId), HttpStatus.OK);
    }



}
