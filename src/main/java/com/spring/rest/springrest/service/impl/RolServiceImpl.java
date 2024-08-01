package com.spring.rest.springrest.service.impl;
import com.spring.rest.springrest.entities.Rol;
import com.spring.rest.springrest.exception.AppException;
import com.spring.rest.springrest.repository.RolCRUDRepository;
import com.spring.rest.springrest.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolCRUDRepository rolCRUDRepository;

    @Override
    public Rol createRol(Rol rol) {
        return rolCRUDRepository.save(rol);
    }

    @Override
    public void deleteRol(Long id) {
        Rol rol = getRolById(id);
        rolCRUDRepository.delete(rol);
    }

    @Override
    public Rol updateRol(Rol rol, Long id) {
        Rol rolToUpdate = getRolById(id);
        rol.setRolId(id);
        return rolCRUDRepository.save(rol);
    }

    @Override
    public Rol getRolById(Long id) {
        Rol rolToUpdate = rolCRUDRepository.findById(id)
                .orElseThrow(() -> new AppException(404, "Rol not found"));
        return rolToUpdate;
    }

    @Override
    public List<Rol> getAllRoles() {
        List<Rol> roles = (List<Rol>) rolCRUDRepository.findAll();
        return roles;
    }
}
