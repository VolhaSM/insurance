package insurance.service;

import insurance.controller.ClientController;
import insurance.pojo.CoverageTypes;
import insurance.pojo.InsuranceClient;
import insurance.pojo.PersonalPolice;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class ClientServiceTest extends ModelTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ClientController clientController;

    @Before
    public void setUp() throws Exception {

        super.setUp();
    }


    @Test
    void createClient() {

        InsuranceClient client = new InsuranceClient();
        client.setFirstName("alex");
        client.setLastName("smith");
        //client.setId(11);


        PersonalPolice police = new PersonalPolice();

        //police.setClientId(11);
        police.setCoverageType(CoverageTypes.FULL_COVERAGE);
        police.setObjectOfInsurance("opel");
        police.setShortDescription("grey");

        List<PersonalPolice> polices = new ArrayList<>();
        polices.add(police);

        client.setPolice(polices);


        //when
        Integer clientId = save(client);
        Integer policeId = client.getPolice().get(0).getId();

        InsuranceClient savedClient = get(clientId);

        //then

        assertNotNull(clientId);
        assertNotNull(policeId);
        assertNotNull(savedClient.getPolice());

        assertEquals(policeId, savedClient.getPolice().get(0).getId());
    }

    @Test
    void getClientById() {
    }

    @Test
    void findAllClients() {
    }

    private Integer save(InsuranceClient client) {

        Session sess = factory.openSession();
        Transaction tx = null;
        Integer clientId;

        try {
            tx = sess.beginTransaction();
            clientId = (Integer) sess.save(client);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();

        }

        return clientId;
    }

    public InsuranceClient get(Integer clientId) { // get by ID
        Session appSession = factory.openSession(); // сессия связи с БД

        InsuranceClient client;
        Transaction tx = null;
        try {
            tx = appSession.beginTransaction();
            client = appSession.get(InsuranceClient.class, clientId);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            throw e;

        } finally {
            appSession.close();
        }


        return client;

    }


    @After
    public void tearDown() throws Exception{
        super.tearDown();
    }
}