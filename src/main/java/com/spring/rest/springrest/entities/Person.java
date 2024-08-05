package com.spring.rest.springrest.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSONID", nullable = false)
    private Long id;
    @Basic
    @Column(name = "IDENTIFY")
    private String identify;
    @Column(name = "TYPEIDENTIFY")
    private String typeIdentify;
    @Column(name = "NAMES")
    private String names;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "AGE")
    private int age;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @OneToOne
    private Client client;


}
