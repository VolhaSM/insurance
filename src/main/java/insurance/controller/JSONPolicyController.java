package insurance.controller;

import insurance.service.JSONPolicyService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class JSONPolicyController {

    private final JSONPolicyService jsonPolicyService;

    @GetMapping("/jsonPolicy/{policeId}")
    public JSONObject getJsonPolice(@PathVariable Integer policeId) {

        return jsonPolicyService.getJsonObject(policeId, "data.json");
    }
}
