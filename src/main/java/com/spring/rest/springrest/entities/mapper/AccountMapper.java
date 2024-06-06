package com.spring.rest.springrest.entities.mapper;

import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.entities.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDTO accountDTO);
    List<Account> toEntity(List<AccountDTO> accountDTO);

    @InheritInverseConfiguration
    AccountDTO toDto(Account account);
    List<AccountDTO> toDto(List<Account> accounts);
}
