package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.dto.PersonalPolicyDTO;
import insurance.model.CoverageTypes;
import insurance.model.PersonalPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
public class EXCELPolicyServiceTest {

    @Autowired
    PersonalPolicyService personalPolicyService;

    @Autowired
    EXCELPolicyService excelPolicyService;

    PersonalPolicy createPolicy() {
        PersonalPolicy policy = new PersonalPolicy();
        policy.setCoverageType(CoverageTypes.FULL_COVERAGE);
        policy.setObjectOfInsurance("car");
        policy.setShortDescription("car_coverage");
        policy.setClientId(1);
        policy.setId(1);
        return policy;
    }

    @Test
    public void writeExcelFile() {

//            String excelPath = "file.xlsx";
//            PersonalPolicyDTO policy = createPolicy();
//            personalPolicyService.createPolice(policy);
//
//            excelPolicyService.writeExcelFile(policy.getId(), excelPath);
        }


}