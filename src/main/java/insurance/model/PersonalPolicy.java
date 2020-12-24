package insurance.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personal_policy")
public class PersonalPolicy {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "object_of_insurance")
    private String objectOfInsurance;
    private CoverageTypes coverageType;
}
