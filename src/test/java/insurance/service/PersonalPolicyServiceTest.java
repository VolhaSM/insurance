package insurance.service;

import insurance.ApplicationConfiguration;
import insurance.pojo.CoverageTypes;
import insurance.pojo.InsuranceClient;
import insurance.pojo.PersonalPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")


public class PersonalPolicyServiceTest {



    @Test
    public void createPolice() {



    }

    @Test
    public void findPoliceById() {
    }

    @Test
    public void findAllPolices() {
    }
}