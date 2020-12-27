package insurance.controller;
import insurance.service.EXCELPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EXCELPolicyController {

    private final EXCELPolicyService excelPolicyService;

    @GetMapping("/excelPolicy/{policyId}")
    public void getExcelPolicy(@PathVariable Long policyId) {

        excelPolicyService.writeExcelFile(policyId, "ex.xlsx");
    }
}
