package insurance.controller;

import insurance.dto.PersonalPolicyDTO;
import insurance.service.PersonalPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalPolicyController {

    @Autowired
    PersonalPolicyService personalPolicyService;

    @PostMapping("/polices")
    public ResponseEntity<PersonalPolicyDTO> createPolicy(@RequestBody PersonalPolicyDTO personalPolicyDTO) {
        return ResponseEntity.ok(personalPolicyService.createPolice(personalPolicyDTO));
    }

    @GetMapping("/polices/{policeId}")
    public ResponseEntity<PersonalPolicyDTO> findPolicyById(@PathVariable Integer policeId) {
        return ResponseEntity.ok(personalPolicyService.findPoliceById(policeId));
    }

    @GetMapping("/polices")
    public ResponseEntity<List<PersonalPolicyDTO>> findAllPolices() {
        return ResponseEntity.ok(personalPolicyService.findAllPolices());
    }
}
