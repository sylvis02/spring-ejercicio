package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    private long userId;

    @Column(name = "PERSONID")
    private Long personId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONID", referencedColumnName = "PERSONID")
    private Person person;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRol> userRols = new ArrayList<>();




}
