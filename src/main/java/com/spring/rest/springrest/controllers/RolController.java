package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.entities.Rol;
import com.spring.rest.springrest.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles/v1")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        return new ResponseEntity<List<Rol>>(rolService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable  Long id) {
        return new ResponseEntity<Rol>(rolService.getRolById(id), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        return new ResponseEntity<Rol>(rolService.createRol(rol), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol, @PathVariable Long id) {
        return new ResponseEntity<Rol>(rolService.updateRol(rol, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
