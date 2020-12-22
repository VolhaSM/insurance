package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.pojo.CoverageTypes;
import insurance.pojo.InsuranceClient;
import insurance.pojo.PersonalPolicy;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")

class ClientServiceTest  {

    @Autowired
    ClientService clientService;

    @Resource
    PersonalPolicyService policyService;

    public InsuranceClient createInsuranceClient() {
        InsuranceClient client = new InsuranceClient();
        client.setId(1);
        client.setFirstName("Bob");
        client.setLastName("Marley");
        client.setPolice(List.of(createNewPolicy()));

        return client;
    }

    public PersonalPolicy createNewPolicy() {
        PersonalPolicy policy = new PersonalPolicy();
        policy.setId(1);
        policy.setClientId(1);
        policy.setObjectOfInsurance("car");
        policy.setShortDescription("black");
        policy.setCoverageType(CoverageTypes.FULL_COVERAGE);

        return policy;


    }

    @Test
    void createClient() {

        InsuranceClient client1 = createInsuranceClient();
        clientService.createClient(client1);
        Optional<InsuranceClient> client = clientService.getClientById(1);
        assertEquals(client1.getId(), client.get().getId());
        assertEquals(client1.getFirstName(), client.get().getFirstName());


    }

    @Test
    void getClientById() {
    }

    @Test
    void findAllClients() {
    }




}