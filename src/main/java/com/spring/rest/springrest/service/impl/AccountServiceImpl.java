package com.spring.rest.springrest.service.impl;

import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.entities.Account;
import com.spring.rest.springrest.entities.CliCta;
import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.exception.AppException;
import com.spring.rest.springrest.entities.mapper.AccountMapper;
import com.spring.rest.springrest.repository.AccountCRUDRepository;
import com.spring.rest.springrest.repository.CliCtaCRUDRepository;
import com.spring.rest.springrest.repository.ClientCRUDRepository;
import com.spring.rest.springrest.service.AccountService;
import com.spring.rest.springrest.service.MovementService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountCRUDRepository accountCRUDRepository;
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CliCtaCRUDRepository cliCtaCRUDRepository;
    @Autowired
    private MovementService movementService;

    @Async
    @Transactional
    @Override
    public void createAccount(AccountDTO accountDTO) {

        Optional<Client> client = Optional.ofNullable(clientCRUDRepository.findByClientId(accountDTO.getClientId()));
        if (!client.isPresent()) {
            throw new AppException(404, "Client not found");
        } else {
            Account accountSave = accountMapper.toEntity(accountDTO);
            Account account = accountCRUDRepository.save(accountSave);
            CliCta cliCta = new CliCta(accountSave.getAccountNumber(), client.get().getClientId());
            cliCtaCRUDRepository.save(cliCta);
            movementService.createMovementInitial(accountSave.getSaltIni(), account.getAccountNumber());

        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return (List<Account>) accountCRUDRepository.findAll();
    }

    @Override
    public Account getAccount(Integer account) {
        return accountCRUDRepository.findById(account).orElseThrow(() ->
                new AppException(404, "Account not found"));

    }
    @Override
    public Account updateAccount(Account account, Integer accountId) {
        Optional<Account> accountOptional = accountCRUDRepository.findById(accountId);

        if (accountOptional.isPresent()) {
            account.setAccountNumber(accountId);
            return accountCRUDRepository.save(account);
        } else {
            throw new AppException(404, "Account not found");
        }
    }
    @Override
    public void deleteAccount(Integer accountId) {
        Optional<Account> accountOptional = accountCRUDRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            accountCRUDRepository.deleteById(accountId);
        } else {
            throw new AppException(404, "Account not found");
        }
    }


}
