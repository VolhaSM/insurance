package insurance.controller;
import insurance.service.JSONPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JSONPolicyController {

    private final JSONPolicyService jsonPolicyService;

    @GetMapping("/jsonPolicy/{policeId}")
    public void getJsonPolice(@PathVariable Long policeId) {
         jsonPolicyService.getJsonObject(policeId, "data.json");
    }
}
