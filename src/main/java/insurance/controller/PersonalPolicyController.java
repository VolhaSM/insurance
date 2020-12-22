package insurance.controller;

import insurance.pojo.PersonalPolicy;
import insurance.service.PersonalPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonalPolicyController {

    @Autowired
    PersonalPolicyService personalPolicyService;

    @PostMapping("/polices")
    public PersonalPolicy createPolice (@RequestBody PersonalPolicy personalPolicy) {
        return personalPolicyService.createPolice(personalPolicy);
    }

    @GetMapping("/polices/{policeId}")
    public Optional<PersonalPolicy> findPoliceById(@PathVariable Integer policeId) {
        return personalPolicyService.findPoliceById(policeId);
    }

    @GetMapping("/polices")
    public List<PersonalPolicy> findAllPolices() {
        return personalPolicyService.findAllPolices();
    }
}
