package insurance.mapper;

import insurance.dto.PersonalPolicyDTO;
import insurance.model.PersonalPolicy;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        uses = {InsuranceClientMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PersonalPolicyMapper {

    PersonalPolicy toPersonalPolicy(PersonalPolicyDTO personalPolicyDTO);


    PersonalPolicyDTO toPersonalPolicyDTO(PersonalPolicy personalPolicy);
}
