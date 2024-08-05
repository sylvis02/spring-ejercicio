package com.spring.rest.springrest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementsDetailDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    @JsonProperty("fecha")
    private Date dateFrom;
    @JsonProperty("cliente")
    private String names;
    @JsonProperty("Numero de cuenta")
    private Integer accountNumber;
    @JsonProperty("tipo")
    private String typeAccount;
    @JsonProperty("saldo inicial")
    private BigDecimal saltIni;
    @JsonProperty("estado")
    private int status;
    @JsonProperty("Movimiento")
    private BigDecimal valueAmount;
    @JsonProperty("Saldo Disponible")
    private BigDecimal saltAmount;
}
