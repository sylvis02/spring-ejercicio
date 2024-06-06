package com.spring.rest.springrest.service;

import com.spring.rest.springrest.entities.Client;

import java.util.List;

public interface ClientService {

    void saveClient(Client client);
    Client getClient(Long clientId);
    Client getClientByIdentify(String identify);
    List<Client> getClientAll();
    void deleteClient(Long clientId);
    Client updateClient(Long clientId, Client client);


}
