package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "T_MOVEMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDMOVEMENT")
    private Long idMovement;
    @Column(name = "ACCOUNTNUMBER")
    private Integer accountNumber;
    @Column(name = "DATEFROM")
    private Date dateFrom;
    @Column(name = "TYPEMOVEMENT")
    private String typeMovement;
    @Column(name = "VALUEAMOUNT")
    private BigDecimal valueAmount;
    @Column(name = "SALTAMOUNT")
    private BigDecimal saltAmount;

}
