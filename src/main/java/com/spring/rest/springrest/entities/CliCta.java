package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "T_CLI_CTA")
@IdClass(CliCtaPk.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CliCta  {
    @Id
    @Column(name = "ACCOUNTNUMBER")
    private Integer accountNumber;
    @Id
    @Column(name = "CLIENTID")
    private Long clientId;

}
