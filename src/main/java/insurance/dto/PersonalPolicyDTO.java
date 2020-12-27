package insurance.dto;
import insurance.model.CoverageTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPolicyDTO {

    private Long id;

    @NotNull
    private Long clientId;
    private String shortDescription;

    @NotNull
    private String objectOfInsurance;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CoverageTypes coverageType;
}
