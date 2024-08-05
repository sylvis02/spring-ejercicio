package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {

    @Autowired
    ClientServiceImpl clientServiceImpl;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<List<Client>>(clientServiceImpl.getClientAll(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClients(@PathVariable("clientId") Long clientId){
        return new ResponseEntity<Client>(clientServiceImpl.getClient(clientId), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createClient(@RequestBody Client client){
        clientServiceImpl.saveClient(client);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId") Long clientId){
        clientServiceImpl.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = "application/json",value = "/{clientId}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client,
                                               @PathVariable("clientId") Long clientId){
        return new ResponseEntity<Client>(clientServiceImpl.updateClient(clientId, client), HttpStatus.OK);
    }



}
