package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.entities.Movement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.rest.springrest.dto.MovementsDetailDTO;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface MovementCRUDRepository extends JpaRepository<Movement, Long> {
    @Query("SELECT new com.spring.rest.springrest.dto.MovementsDetailDTO(" +
            "      m.dateFrom, " +
            "      cl.names, " +
            "      m.accountNumber, " +
            "      acc.typeAccount, " +
            "      acc.saltIni, " +
            "      acc.status, " +
            "      CASE WHEN m.typeMovement ='DEBIT' THEN -m.valueAmount ELSE m.valueAmount END, " +
            "      m.saltAmount) " +
            "FROM Movement m " +
            "INNER JOIN Account acc ON m.accountNumber = acc.accountNumber " +
            "INNER JOIN CliCta c ON c.accountNumber = m.accountNumber " +
            "INNER JOIN Client cl ON c.clientId = cl.clientId " +
            "WHERE (:identify IS NULL OR cl.identify = :identify) " +
            "AND m.dateFrom >= :fechaIni " +
            "AND m.dateFrom <= :fechaFin")
    public List<MovementsDetailDTO> findReportMapperByIdentifyFechaIni(Pageable pageable,
                                                                       @Param("identify") String identify,
                                                                       @Param("fechaIni") Date fechaIni,
                                                                       @Param("fechaFin") Date fechaFin
    );
    public Optional<Movement> findTopByAccountNumberOrderByIdMovementDesc(Integer accountNumber);

}
