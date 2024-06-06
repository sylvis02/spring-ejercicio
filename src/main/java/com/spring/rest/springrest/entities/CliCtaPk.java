package com.spring.rest.springrest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CliCtaPk  implements Serializable {
    private Integer accountNumber;
    private Long clientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CliCtaPk cliCtaPk = (CliCtaPk) o;
        return Objects.equals(accountNumber, cliCtaPk.accountNumber) && Objects.equals(clientId, cliCtaPk.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, clientId);
    }
}
