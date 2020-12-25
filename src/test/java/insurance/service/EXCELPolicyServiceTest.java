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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@Transactional
public class EXCELPolicyServiceTest {

    @Resource
    PersonalPolicyService personalPolicyService;

    @Resource
    EXCELPolicyService excelPolicyService;

    PersonalPolicyDTO createPolicy() {
        PersonalPolicyDTO policy = new PersonalPolicyDTO();
        policy.setCoverageType(CoverageTypes.FULL_COVERAGE);
        policy.setObjectOfInsurance("car");
        policy.setShortDescription("car_coverage");
        policy.setClientId(1);
        policy.setId(1);
        return policy;
    }

    @Test
    public void writeExcelFile() {

        String excelPath = "file.xlsx";
        PersonalPolicyDTO policy = createPolicy();
        personalPolicyService.createPolice(policy);

        excelPolicyService.writeExcelFile(policy.getId(), excelPath);
        File file = new File(excelPath);
        assertEquals(file.getName(), excelPath);
        assertTrue(file.exists());
        assertTrue(file.delete());
    }


}