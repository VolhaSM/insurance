package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.dto.PersonalPolicyDTO;
import insurance.mapper.PersonalPolicyMapper;
import insurance.model.CoverageTypes;
import insurance.model.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@Transactional

public class PersonalPolicyServiceTest {

    @MockBean
    PersonalPoliceRepo personalPolicyRepo;

    @Resource
    PersonalPolicyService personalPolicyService;

    @Resource
    PersonalPolicyMapper personalPolicyMapper;


    @Test
    public void createPolice() {

        PersonalPolicyDTO policy =
                new PersonalPolicyDTO(1, 2, "description", "House", CoverageTypes.FULL_COVERAGE);
        personalPolicyService.createPolice(policy);
        Mockito.verify(personalPolicyRepo, Mockito.times(1))
                .save(personalPolicyMapper.toPersonalPolicy(policy));
    }


    @Test
    public void findPoliceById() {

        given(this.personalPolicyRepo.findById(1))
                .willReturn(new PersonalPolicy(1, 1, "description", "car", CoverageTypes.FULL_COVERAGE));
        PersonalPolicyDTO personalPolicy = personalPolicyService.findPoliceById(1);
        assertEquals(1, (int) personalPolicy.getId());
        Mockito.verify(personalPolicyRepo, Mockito.times(1)).findById(1);
        assertEquals(1, (int) personalPolicy.getId());
        assertEquals(1, (int) personalPolicy.getClientId());
        assertEquals("description", personalPolicy.getShortDescription());
        assertEquals("car", personalPolicy.getObjectOfInsurance());

    }

    @Test
    public void findAllPolices() {

        personalPolicyService.findAllPolices();
        Mockito.verify(personalPolicyRepo, Mockito.times(1)).findAll();
    }
}