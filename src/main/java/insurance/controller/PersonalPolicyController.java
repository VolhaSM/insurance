package insurance.controller;

import insurance.pojo.PersonalPolice;
import insurance.service.PersonalPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonalPolicyController {

    @Autowired
    PersonalPoliceService personalPoliceService;

    @PostMapping("/polices")
    public PersonalPolice createPolice (@RequestBody PersonalPolice personalPolice) {
        return personalPoliceService.createPolice(personalPolice);
    }

    @GetMapping("/polices/{policeId}")
    public Optional<PersonalPolice> findPoliceById(@PathVariable Integer policeId) {
        return personalPoliceService.findPoliceById(policeId);
    }

    @GetMapping("/polices")
    public List<PersonalPolice> findAllPolices() {
        return personalPoliceService.findAllPolices();
    }
}
