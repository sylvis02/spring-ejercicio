package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCRUDRepository extends JpaRepository<Client, Long> {

    public Client findByClientId(Long clientId);

    public Client findByPersonIdentify(String identify);

}
