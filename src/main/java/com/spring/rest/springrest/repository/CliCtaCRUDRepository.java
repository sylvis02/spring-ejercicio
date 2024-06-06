package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.CliCta;
import com.spring.rest.springrest.entities.CliCtaPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliCtaCRUDRepository extends CrudRepository<CliCta, CliCtaPk> {


}
