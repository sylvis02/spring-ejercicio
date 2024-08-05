package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Client extends Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENTID")
    private Long clientId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private int status;



}
