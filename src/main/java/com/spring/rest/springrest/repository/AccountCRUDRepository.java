package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCRUDRepository extends CrudRepository<Account, Integer> {


}
