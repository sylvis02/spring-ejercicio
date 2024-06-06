package com.spring.rest.springrest;

import com.spring.rest.springrest.controllers.AccountController;
import com.spring.rest.springrest.controllers.ClientController;
import com.spring.rest.springrest.controllers.MovementController;
import com.spring.rest.springrest.controllers.ReportesController;
import com.spring.rest.springrest.datos.PopulateCliente;
import com.spring.rest.springrest.dto.AccountDTO;
import com.spring.rest.springrest.dto.MovementDTO;
import com.spring.rest.springrest.dto.MovementsDetailDTO;
import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.exception.AppException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientControllerIntegrationTest {
    private static final Logger logger = Logger.getLogger(ClientControllerIntegrationTest.class.getName());

    @Autowired
    private ClientController clientController;

    @Autowired
    private AccountController accountController;

    @Autowired
    private MovementController movementController;

    @Autowired
    private ReportesController reportesController;


    // @Test
    void testGetClient() {

        //Crear un cliente exitoso
        PopulateCliente populateCliente = new PopulateCliente();
        Client client = populateCliente.getCliente();

        ResponseEntity<Void> responseEntity = clientController.createClient(client);
        assertEquals(201, responseEntity.getStatusCodeValue());

        //Obtener un cliente y verificar que retorne 200
        ResponseEntity<Client> responseGet = clientController.getClientsByIdentify(client.getPerson().getIdentify());
        assertEquals(200, responseGet.getStatusCodeValue());

        //Crear la cuenta movimiento inicial
        AccountDTO accountDTO = populateCliente.populateAccount();
        accountDTO.setClientId(responseGet.getBody().getPerson().getId());
        ResponseEntity<Void> responseAccount = accountController.createAccount(accountDTO);
        assertEquals(201, responseAccount.getStatusCodeValue());

        //CrearMovimientos
        ResponseEntity<List<MovementsDetailDTO>> responseMovements =
                reportesController.getMovementDetail(new Date(), new Date(),
                        client.getPerson().getIdentify(), 0, 10);

        //Verificar que hay mas de un movimiento de la primera cuenta que se creo
        assertEquals(200, responseMovements.getStatusCodeValue());
        assertEquals(true, responseMovements.getBody().size() > 0);


    }

    //@Test
    void testSaldoNoDisponible() {
        //Colocar una cuenta definida

        MovementDTO movementDTO = MovementDTO.builder()
                .accountNumber(1)
                .typeMovement("DEBIT")
                .valueAmount(new BigDecimal(90000))
                .build();
        movementDTO.setAccountNumber(2);

            assertThrows(AppException.class, () -> {
                movementController.createMovement(movementDTO);
                logger.log(Level.INFO, "Saldo insuficiente");
            });


    }

    //@Test
    void testReporte() {
        int pageSize = 3;
        for (int i = 0; i < 4; i++) {
            List<MovementsDetailDTO> actualResults = reportesController.getMovementDetail(
                    new Date(),
                    new Date(),
                    null, i, pageSize).getBody();
            logger.log(Level.INFO, "Pagina: " + i + " " + actualResults.size());
            assertEquals(actualResults.size(), pageSize);


        }
    }
}
