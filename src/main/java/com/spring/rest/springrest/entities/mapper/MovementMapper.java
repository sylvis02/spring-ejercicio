package com.spring.rest.springrest.entities.mapper;
import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.entities.Movement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    Movement toEntity(MovementDTO movementDTO);
    List<Movement> toEntity(List<MovementDTO> movementDTO);

    @InheritInverseConfiguration
    MovementDTO toDto(Movement movement);
    List<MovementDTO> toDto(List<Movement> movements);
}
