package com.spring.rest.springrest.service;

import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.entities.Movement;

import java.math.BigDecimal;
import java.util.List;

public interface MovementService {
    Movement createMovement(MovementDTO movementDTO);
    void deleteMovement(Long id) ;
    Movement getMovementById(Long id);
    Movement updateMovement(Long id, Movement movement);
    List<Movement> getAllMovements();
    Movement createMovementInitial(BigDecimal saltIni, Integer accountNumber);

}
