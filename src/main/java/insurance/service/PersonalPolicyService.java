package insurance.service;

import insurance.dto.PersonalPolicyDTO;
import insurance.mapper.PersonalPolicyMapper;
import insurance.model.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonalPolicyService {

    private final PersonalPoliceRepo personalPoliceRepo;
    private final PersonalPolicyMapper personalPolicyMapper;

    public PersonalPolicyDTO createPolice(PersonalPolicyDTO personalPolicyDTO) {

        PersonalPolicy savedPolicy =
                personalPoliceRepo.save(personalPolicyMapper.toPersonalPolicy(personalPolicyDTO));

        return personalPolicyMapper.toPersonalPolicyDTO(savedPolicy);
    }

    public PersonalPolicyDTO findPoliceById(long policeId) {

        return personalPolicyMapper.toPersonalPolicyDTO(personalPoliceRepo.findById(policeId));

    }

    public List<PersonalPolicyDTO> findAllPolices() {

        return personalPoliceRepo.findAll()
                .stream()
                .map(s -> personalPolicyMapper.toPersonalPolicyDTO(s))
                .collect(Collectors.toList());
    }

}
