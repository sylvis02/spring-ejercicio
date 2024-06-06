package com.spring.rest.springrest.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.math.BigDecimal;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @NotBlank(message = "Account Number is required")
    private Integer accountNumber;
    @NotBlank(message = "Type is required")
    private String typeAccount;
    private BigDecimal saltIni ;
    @NotBlank(message = "Status is required")
    private int status;
    @NotBlank(message = "Client Id is required")
    private Long clientId;

}
