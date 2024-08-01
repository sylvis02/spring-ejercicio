package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCRUDRepository extends CrudRepository<User, Long> {
}
