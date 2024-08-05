package com.spring.rest.springrest;


import com.spring.rest.springrest.datos.PopulateCliente;
import com.spring.rest.springrest.entities.Client;
import com.spring.rest.springrest.repository.ClientCRUDRepository;
import com.spring.rest.springrest.service.impl.ClientServiceImpl;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class SpringrestApplicationTests {

    public static final Logger logger = LoggerFactory.getLogger(SpringrestApplicationTests.class);
    @Mock
    ClientCRUDRepository clientCRUDRepository;

    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    private PopulateCliente populateCliente = new PopulateCliente();
    private List<Client> listClients = new ArrayList<>();

    @BeforeEach
    void setUp() {

        clientCRUDRepository = mock(ClientCRUDRepository.class);
        clientServiceImpl = new ClientServiceImpl(clientCRUDRepository);
        //llenamos 3 clientes de prueba
        for(int i = 0; i < 3; i++){
            listClients.add(populateCliente.clientSinGeneracionPersonId());
        }
        for (Client client : listClients) {
            when(clientCRUDRepository.findByClientId(client.getId())).thenReturn(client);

        }
    }

   // @Test
    void testClient() {

        for (Client client : listClients) {
            Client result = clientServiceImpl.getClient((client.getId()));
            //Verificar que el resultado no sea nulo
            assertNotNull(result);
            verifyClient(client, result);

            //Verificar que el metodo del repositorio se llamo una vez
            verify(clientCRUDRepository, times(1)).findByClientId((client.getId()));

        }

    }

    private void verifyClient(Client expected, Client actual) {
        assertEquals(expected.getNames(), actual.getNames());
        assertEquals(expected.getAge(), actual.getAge());
        assertEquals(expected.getGender(), actual.getGender());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getPhone(), actual.getPhone());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getIdentify(), actual.getIdentify());
        assertEquals(expected.getTypeIdentify(), actual.getTypeIdentify());
    }


}
