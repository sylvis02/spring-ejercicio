package com.spring.rest.springrest.service;

import com.spring.rest.springrest.dto.MovementsDetailDTO;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<MovementsDetailDTO> getMovementsDetail(Date fechaIni,
                                                Date FechaFin,
                                                String client,
                                                int page,
                                                int size);
}
