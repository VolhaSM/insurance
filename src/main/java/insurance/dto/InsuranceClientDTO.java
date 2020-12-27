package insurance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceClientDTO {

    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private List<PersonalPolicyDTO> police;
}
