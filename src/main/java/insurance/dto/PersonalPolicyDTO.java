package insurance.dto;

import insurance.model.CoverageTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPolicyDTO {

    private Integer id;
    @NotNull
    private Integer clientId;
    private String shortDescription;
    @NotNull
    private String objectOfInsurance;
    @NotNull
    private CoverageTypes coverageType;
}
