package com.spring.rest.springrest.service;

import com.spring.rest.springrest.entities.Rol;

import java.util.List;

public interface RolService {

    Rol createRol(Rol rol);

    void deleteRol(Long id);

    Rol updateRol(Rol rol, Long id);

    Rol getRolById(Long id);

    List<Rol>getAllRoles();
}
