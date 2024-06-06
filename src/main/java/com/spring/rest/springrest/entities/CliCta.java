package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_CLI_CTA")
@IdClass(CliCtaPk.class)
public class CliCta  {
    @Id
    @Column(name = "ACCOUNTNUMBER")
    private Integer accountNumber;
    @Id
    @Column(name = "CLIENTID")
    private Long clientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CliCta cliCta = (CliCta) o;
        return Objects.equals(accountNumber, cliCta.accountNumber) && Objects.equals(clientId, cliCta.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, clientId);
    }
}
