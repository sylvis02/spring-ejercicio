package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.entities.Movement;
import com.spring.rest.springrest.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements/v1")
public class MovementController {
    @Autowired
    MovementService movementService;

    @GetMapping
    public ResponseEntity<List<Movement>> getMovement() {
       return new ResponseEntity<List<Movement>>(movementService.getAllMovements(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movement> getMovementById(@PathVariable Long id) {
        return new ResponseEntity<Movement>(movementService.getMovementById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Movement> createMovement(@RequestBody MovementDTO movement) {
        return new ResponseEntity<Movement>(movementService.createMovement(movement), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", value = "/{id}")
    public ResponseEntity<Movement> updateMovement(@RequestBody Movement movement,
                                                   @PathVariable Long id) {
        return new ResponseEntity<Movement>(movementService.updateMovement(id, movement), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
