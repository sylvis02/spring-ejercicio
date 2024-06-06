package com.spring.rest.springrest.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementDTO {
    private Integer accountNumber;
    private String typeMovement;
    private BigDecimal valueAmount;
    private Date dateFrom;

}
