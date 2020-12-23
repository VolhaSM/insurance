package insurance.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonalPolicy {
    @Id
    private Integer id;
    private Integer clientId;
    private String shortDescription;
    private String objectOfInsurance;
    private CoverageTypes coverageType;
}
