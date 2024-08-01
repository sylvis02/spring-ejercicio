package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "T_CLIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Client extends Person {
    @Id
    @Column(name = "CLIENTID")
    private Long clientId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private int status;
    @OneToOne( mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTID", referencedColumnName = "PERSONID" )
    Person person;


}
