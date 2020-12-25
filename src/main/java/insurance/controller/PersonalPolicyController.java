package insurance.controller;

import insurance.dto.PersonalPolicyDTO;
import insurance.service.PersonalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonalPolicyController {

    private final PersonalPolicyService personalPolicyService;

    @PostMapping("/polices")
    public ResponseEntity<PersonalPolicyDTO> createPolicy(@RequestBody @Valid PersonalPolicyDTO personalPolicyDTO) {
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
