package com.spring.rest.springrest.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ACCOUNTNUMBER")
    private Integer accountNumber;
    @Column(name = "TYPEACCOUNT")
    private String typeAccount;
    @Column(name = "SALTINI")
    private BigDecimal saltIni;
    @Column(name = "STATUS")
    private int status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNTNUMBER", referencedColumnName = "ACCOUNTNUMBER")
    private List<Movement> movements;


}
