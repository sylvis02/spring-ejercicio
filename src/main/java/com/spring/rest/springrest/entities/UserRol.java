package com.spring.rest.springrest.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.List;

@Entity
@Table(name = "T_USERROL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRol {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLID")
    private Rol rol;


}
