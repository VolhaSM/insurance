package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.model.CoverageTypes;
import insurance.model.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)


public class PersonalPolicyServiceTest {


    @MockBean
    PersonalPoliceRepo personalPolicyRepo;

    @Autowired
    PersonalPolicyService personalPolicyService;


    @Test
    public void createPolice() {

//        PersonalPolicy policy =
//                new PersonalPolicy(1, 2, "description", "House", CoverageTypes.FULL_COVERAGE);
//        personalPolicyService.createPolice(policy);
//
//        Mockito.verify(personalPolicyRepo, Mockito.times(1)).save(policy);
  }


    @Test
    public void findPoliceById() {

//        given(this.personalPolicyRepo.findById(any()))
//                .willReturn(java.util.Optional.of(new PersonalPolicy(1, 1, "description", "car", CoverageTypes.FULL_COVERAGE)));
//        Optional<PersonalPolicy> personalPolice = personalPolicyService.findPoliceById(5);
//        assertEquals(1, (int) personalPolice.get().getId());
//        Mockito.verify(personalPolicyRepo, Mockito.times(1)).findById(any());
//
    }

    @Test
    public void findAllPolices() {

        personalPolicyService.findAllPolices();

        Mockito.verify(personalPolicyRepo, Mockito.times(1)).findAll();
    }
}