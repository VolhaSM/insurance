package insurance.mapper;

import insurance.dto.InsuranceClientDTO;
import insurance.model.InsuranceClient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import springfox.documentation.swagger2.mappers.LicenseMapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        uses = {PersonalPolicyMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface InsuranceClientMapper {

    InsuranceClient toInsuranceClient(InsuranceClientDTO insuranceClientDTO);

    InsuranceClientDTO toInsuranceClientDTO(InsuranceClient insuranceClient);
}
