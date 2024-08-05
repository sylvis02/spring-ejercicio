package com.spring.rest.springrest.service.impl;

import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.exception.AppException;
import com.spring.rest.springrest.repository.ClientCRUDRepository;
import com.spring.rest.springrest.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientCRUDRepository clientCRUDRepository;


    public ClientServiceImpl(ClientCRUDRepository clientCRUDRepository) {
        this.clientCRUDRepository = clientCRUDRepository;
    }

    @Async
    @Transactional
    @Override
    public void saveClient(Client client) {
        clientCRUDRepository.save(client);
    }
    @Override
    public Client getClient(Long clientId) {
        Optional<Client> client = Optional.ofNullable(clientCRUDRepository.findByClientId(clientId));
        if (client.isPresent()){
            return client.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Client not found %s", clientId));
        }
    }

    @Override
    public List<Client> getClientAll(){
        return clientCRUDRepository.findAll().stream().toList();
    }

    public void deleteClient(Long clientId) {
        Client client = clientCRUDRepository.findByClientId(clientId);
        if (Objects.nonNull(client)) {
            clientCRUDRepository.delete(client);
        } else {
            throw new AppException(404, "Client not found");
        }
    }
    @Override
    public Client updateClient(Long clientId, Client client) {
        if (Objects.nonNull(clientCRUDRepository.findByClientId(clientId))) {
            client.setClientId(clientId);
            return clientCRUDRepository.save(client);
        } else {
            throw new AppException(404, "Client not found");
        }
    }

}
