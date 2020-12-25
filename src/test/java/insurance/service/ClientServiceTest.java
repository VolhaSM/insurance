package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.dto.InsuranceClientDTO;
import insurance.dto.PersonalPolicyDTO;
import insurance.mapper.InsuranceClientMapper;
import insurance.mapper.PersonalPolicyMapper;
import insurance.model.CoverageTypes;
import insurance.repository.ClientRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")
@Transactional
class ClientServiceTest {


    @Resource
    ClientService clientService;

    @Resource
    InsuranceClientMapper insuranceClientMapper;

    @MockBean
    ClientRepo clientRepo;

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

        InsuranceClientDTO client = createInsuranceClient();
        clientService.createClient(client);

        Mockito.verify(clientRepo, Mockito.times(1))
                .save(insuranceClientMapper.toInsuranceClient(client));

    }

    @Test
    void getClientById() {

        given(clientRepo.findById(1))
                .willReturn(insuranceClientMapper.toInsuranceClient(createInsuranceClient()));

        InsuranceClientDTO insuranceClientDTO = clientService.getClientById(1);

        Mockito.verify(clientRepo, Mockito.times(1)).findById(1);
        assertEquals(1, insuranceClientDTO.getId());
        assertEquals("Bob", insuranceClientDTO.getFirstName());
        assertEquals("Marley", insuranceClientDTO.getLastName());
        assertEquals(1, insuranceClientDTO.getPolice().size());
    }

    @Test
    void findAllClients() {

        clientService.findAllClients();
        Mockito.verify(clientRepo, Mockito.times(1)).findAll();
    }


}