package insurance.controller;

import insurance.pojo.PersonalPolicy;
import insurance.service.EXCELPolicyService;
import insurance.service.JSONPolicyService;
import insurance.service.PersonalPolicyService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EXCELPolicyController {

    @Autowired
    PersonalPolicyService personalPolicyService;

    @Autowired
    EXCELPolicyService excelPolicyService;

    @GetMapping("/excelPolicy/{policeId}")
    public void getExcelPolicy(@PathVariable Integer policeId) {

        excelPolicyService.writeExcelFile(policeId, "ex.xlsx");
    }
}
