package insurance.controller;

import insurance.service.JSONPolicyService;
import insurance.service.PersonalPolicyService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JSONPolicyController {

    @Autowired
    PersonalPolicyService personalPolicyService;

    @Autowired
    JSONPolicyService jsonPolicyService;

    @GetMapping("/jsonPolicy/{policeId}")
    public JSONObject getJsonPolice(@PathVariable Integer policeId) {

        return jsonPolicyService.getJsonObject(policeId);
    }
}
