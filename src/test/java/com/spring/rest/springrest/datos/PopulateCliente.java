package com.spring.rest.springrest.datos;

import com.github.javafaker.Faker;
import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.entities.Person;

import java.math.BigDecimal;
import java.util.Date;

public class PopulateCliente {


    private Faker faker = new Faker();

    public Client getCliente() {
        //Person persona = new Person();
        Client cliente = new Client();
        cliente.setTypeIdentify(faker.options().option("C", "R"));
        cliente.setIdentify(faker.idNumber().valid());
        cliente.setNames(faker.name().fullName());
        cliente.setAge(faker.number().numberBetween(18, 80));
        cliente.setGender(faker.options().option("M", "F"));
        cliente.setAddress(faker.address().fullAddress());
        cliente.setPhone(faker.phoneNumber().cellPhone());

        //cliente.setPerson(persona);
        cliente.setPassword(faker.internet().password());
        cliente.setStatus(1);
        return cliente;
    }
    public Client clientSinGeneracionPersonId() {
        BigDecimal id = new BigDecimal(-10000);
        Client cliente = new Client();
        cliente.setId(faker.number().randomNumber());
        cliente.setTypeIdentify(faker.options().option("C", "R"));
        cliente.setIdentify(faker.idNumber().valid());
        cliente.setNames(faker.name().fullName());
        cliente.setAge(faker.number().numberBetween(18, 80));
        cliente.setGender(faker.options().option("M", "F"));
        cliente.setAddress(faker.address().fullAddress());
        cliente.setPhone(faker.phoneNumber().cellPhone());

        //cliente.setPerson(persona);
        cliente.setPassword(faker.internet().password());
        cliente.setStatus(1);
        return cliente;
    }

    public AccountDTO populateAccount() {

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber(faker.number().numberBetween(1000, 9999));
        accountDTO.setTypeAccount(faker.options().option("AHORRO", "CORRIENTE"));
        accountDTO.setSaltIni(new BigDecimal(faker.commerce().price(100, 999999999)));
        accountDTO.setStatus(1);
        return accountDTO;
    }

    public MovementDTO populateMovement() {
        MovementDTO movementDTO = new MovementDTO();
        movementDTO.setDateFrom(new Date());
        movementDTO.setTypeMovement(faker.options().option("DEBIT", "CREDIT"));
        movementDTO.setValueAmount(new BigDecimal(faker.commerce().price(100, 999999999)));

        return movementDTO;
    }

}
