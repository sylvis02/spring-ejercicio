package com.spring.rest.springrest.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CliCtaPk  implements Serializable {
    private Integer accountNumber;
    private Long clientId;


}
