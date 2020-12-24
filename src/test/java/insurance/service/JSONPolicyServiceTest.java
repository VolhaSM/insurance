package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.dto.PersonalPolicyDTO;
import insurance.model.CoverageTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@Transactional
public class JSONPolicyServiceTest {

    @Resource
    PersonalPolicyService personalPolicyService;

    @Resource
    JSONPolicyService jsonPolicyService;

    PersonalPolicyDTO createPolice(){
        PersonalPolicyDTO policyDTO = new PersonalPolicyDTO();
        policyDTO.setClientId(1);
        policyDTO.setId(1);
        policyDTO.setObjectOfInsurance("car");
        policyDTO.setShortDescription("black");
        policyDTO.setCoverageType(CoverageTypes.FULL_COVERAGE);

        return policyDTO;
    }

    @Test
    public void getJsonObject() {
        PersonalPolicyDTO personalPolicyDTO = personalPolicyService.createPolice(createPolice());
        jsonPolicyService.getJsonObject(personalPolicyDTO.getId());
        File file = new File("data.json");

        assertTrue(file.exists());
        assertEquals( "data.json", file.getName());


    }
}