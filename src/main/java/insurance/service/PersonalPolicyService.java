package insurance.service;

import insurance.dto.PersonalPolicyDTO;
import insurance.mapper.PersonalPolicyMapper;
import insurance.model.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalPolicyService {

    @Autowired
    PersonalPoliceRepo personalPoliceRepo;

    @Autowired
    PersonalPolicyMapper personalPolicyMapper;

    public PersonalPolicyDTO createPolice(PersonalPolicyDTO personalPolicyDTO) {

        PersonalPolicy savedPolicy =
                personalPoliceRepo.save(personalPolicyMapper.toPersonalPolicy(personalPolicyDTO));

        return personalPolicyMapper.toPersonalPolicyDTO(savedPolicy);
    }

    public PersonalPolicyDTO findPoliceById(int policeId) {


        return personalPolicyMapper.toPersonalPolicyDTO(personalPoliceRepo.findById(policeId));

    }

    public List<PersonalPolicyDTO> findAllPolices() {

        return personalPoliceRepo.findAll()
                .stream()
                .map(s -> personalPolicyMapper.toPersonalPolicyDTO(s))
                .collect(Collectors.toList());
    }

}
