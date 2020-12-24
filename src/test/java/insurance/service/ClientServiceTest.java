package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.dto.InsuranceClientDTO;
import insurance.dto.PersonalPolicyDTO;
import insurance.model.CoverageTypes;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")
@Transactional
class ClientServiceTest {


    @Resource
    ClientService clientService;
    @Resource
    PersonalPolicyService policyService;


    public InsuranceClientDTO createInsuranceClient() {
        InsuranceClientDTO client = new InsuranceClientDTO();
        client.setId(1);
        client.setFirstName("Bob");
        client.setLastName("Marley");
        client.setPolice(List.of(createNewPolicy()));

        return client;
    }


    public PersonalPolicyDTO createNewPolicy() {
        PersonalPolicyDTO policy = new PersonalPolicyDTO();
        policy.setId(1);
        policy.setClientId(1);
        policy.setObjectOfInsurance("car");
        policy.setShortDescription("black");
        policy.setCoverageType(CoverageTypes.FULL_COVERAGE);

        return policy;


    }

    @Test
    void createClient() {

        InsuranceClientDTO client1 = createInsuranceClient();
        clientService.createClient(client1);
        InsuranceClientDTO client = clientService.getClientById(1);
        assertEquals(client1.getId(), client.getId());
        assertEquals(client1.getFirstName(), client.getFirstName());

    }

    @Test
    void getClientById() {

        clientService.createClient(createInsuranceClient());
        InsuranceClientDTO client = clientService.getClientById(1);
        assertEquals(client.getId(), 1);
        assertEquals("Bob", client.getFirstName());
    }

    @Test
    void findAllClients() {

        clientService.createClient(createInsuranceClient());
        List<InsuranceClientDTO> clients = clientService.findAllClients();
        assertEquals(clients.size(), 1);
    }


}