package com.spring.rest.springrest.service.impl;

import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.entities.Movement;
import com.spring.rest.springrest.exception.AppException;
import com.spring.rest.springrest.entities.mapper.MovementMapper;
import com.spring.rest.springrest.repository.MovementCRUDRepository;
import com.spring.rest.springrest.service.MovementService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.spring.rest.springrest.constant.Constans.*;

@Service
public class MovementServiceImpl implements MovementService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MovementServiceImpl.class);
    @Autowired
    private MovementCRUDRepository movementCRUDRepository;
    @Autowired
    private MovementMapper movementMapper;

    @Transient
    @Override
    public Movement createMovement(MovementDTO movementDTO)  {
        Optional<Integer> accountNumber = Optional.ofNullable(movementDTO.getAccountNumber());
        if (accountNumber.isEmpty() || !accountNumber.isPresent()){
            throw new IllegalArgumentException("Numero de cuenta es requerido");
        }
        Optional<String> typeMovement = Optional.ofNullable(movementDTO.getTypeMovement());
        if (typeMovement.isEmpty() || !typeMovement.isPresent()){
            throw new IllegalArgumentException("Tipo de movimiento es requerido");
        }

        Optional<Movement> movementOptional =
                Optional.ofNullable(movementCRUDRepository.findTopByAccountNumberOrderByIdMovementDesc(movementDTO.getAccountNumber()).orElseThrow(()
                        -> new AppException(404, ACCOUNT_NOT_FOUND)));

        Movement movement = movementMapper.toEntity(movementDTO);
        logger.info("Saldo disponible: " + movementOptional.get().getSaltAmount());

        if (movementDTO.getTypeMovement().equalsIgnoreCase(DEBIT)
                && movementOptional.get().getSaltAmount().compareTo(movementDTO.getValueAmount()) < 0) {
            throw new AppException(501, INSUFFICIENT_BALANCE);
        } else {
            movement.setSaltAmount(movementOptional.get().getSaltAmount().subtract(
                    (movement.getValueAmount())
            ));
        }
        if (movement.getTypeMovement().equalsIgnoreCase(CREDIT)) {
            movement.setSaltAmount(movementOptional.get().getSaltAmount().add(
                    (movement.getValueAmount())
            ));
        }
        Optional<Date> dateFrom = Optional.ofNullable(movementDTO.getDateFrom());

        if(dateFrom.isPresent()){
            movement.setDateFrom(new Date());
        }
        return movementCRUDRepository.save(movement);
    }
    @Override
    public void deleteMovement(Long id) {
        Optional<Movement> movement = movementCRUDRepository.findById(id);
        if (movement.isPresent()) {
            movementCRUDRepository.deleteById(id);
        } else {
            throw new AppException(404, "Movement not found");
        }
    }
    @Override
    public Movement getMovementById(Long id) {
        return movementCRUDRepository.findById(id).orElseThrow(()
                -> new AppException(404, "Movement not found"));
    }
    @Override
    public Movement updateMovement(Long id, Movement movement) {
        Optional<Movement> movementDB = movementCRUDRepository.findById(id);
        if (movementDB.isPresent()) {
            movement.setIdMovement(id);
            return movementCRUDRepository.save(movement);
        } else {
            throw new AppException(404, "Movement not found");
        }

    }
    @Override
    public List<Movement> getAllMovements() {
        List<Movement> movements = (List<Movement>) movementCRUDRepository.findAll();
        return movements;
    }
    @Override
    public Movement createMovementInitial(BigDecimal saltIni, Integer accountNumber) {
        Movement movement = new Movement();
        movement.setSaltAmount(saltIni);
        movement.setTypeMovement(CREDIT);
        movement.setDateFrom(new Date());
        movement.setValueAmount(saltIni);
        movement.setAccountNumber(accountNumber);
        return movementCRUDRepository.save(movement);
    }

}

