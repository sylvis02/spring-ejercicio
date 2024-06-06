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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return status == account.status && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(typeAccount, account.typeAccount) && Objects.equals(saltIni, account.saltIni) && Objects.equals(movements, account.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, typeAccount, saltIni, status, movements);
    }
}
