package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.dto.MovementsDetailDTO;
import com.spring.rest.springrest.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reports/v1")
public class ReportesController {

    @Autowired
    ReportService reportsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @GetMapping
    public ResponseEntity<List<MovementsDetailDTO>> getMovementDetail(@RequestParam(value = "fechaIni", required = true) Date fechaIni,
                                                                      @RequestParam(value = "fechaFin", required = true) Date fechaFin,
                                                                      @RequestParam(value = "client", required = false) String client,
                                                                      @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                                      @RequestParam(value = "size", defaultValue = "10", required = false) int size)  {


        return new ResponseEntity<List<MovementsDetailDTO>>(reportsService.getMovementsDetail(fechaIni,
                fechaFin, client, page, size), HttpStatus.OK);
    }

}
