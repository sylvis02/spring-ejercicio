package com.spring.rest.springrest.service.impl;
import com.spring.rest.springrest.constant.Constans;
import com.spring.rest.springrest.dto.MovementsDetailDTO;
import com.spring.rest.springrest.repository.MovementCRUDRepository;
import com.spring.rest.springrest.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportsServiceImpl implements ReportService {
    public final static Logger logger = LoggerFactory.getLogger(ReportsServiceImpl.class);

    @Autowired
    private MovementCRUDRepository movementCRUDRepository;

    @Autowired
    Constans constans;

    @Override
    public List<MovementsDetailDTO> getMovementsDetail(Date fechaIni,
                                                       Date FechaFin,
                                                       String client,
                                                       int page,
                                                       int size)  {

        Optional<Date> dateIni = Optional.ofNullable(fechaIni);
        Optional<Date> datefin = Optional.ofNullable(FechaFin);

        if( datefin.isEmpty() || dateIni.isEmpty() ){
            throw new IllegalArgumentException("Fecha de inicio y fecha de fin son requeridos");
        }

        if(dateIni.get().after(datefin.get())){
            throw new IllegalArgumentException("La fecha de inicio no puede ser mayor a la fecha de fin");
        }



        List<MovementsDetailDTO> result = movementCRUDRepository.findReportMapperByIdentifyFechaIni(PageRequest.of(page,
                size, Sort.Direction.DESC, "dateFrom"), client, constans.truncateTime(fechaIni), constans.endOfDay(FechaFin));

        return result;
    }
}
