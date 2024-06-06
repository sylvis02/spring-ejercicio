package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Entity
@Table(name = "T_CLIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "CLIENTID")
    private Long clientId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private int status;
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTID", referencedColumnName = "PERSONID" )
    Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return status == client.status && Objects.equals(clientId, client.clientId) && Objects.equals(password, client.password) && Objects.equals(person, client.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, password, status, person);
    }
}
