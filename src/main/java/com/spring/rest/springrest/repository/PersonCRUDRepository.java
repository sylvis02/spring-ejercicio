package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCRUDRepository extends CrudRepository<Person, Long> {


}
