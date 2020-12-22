package insurance.service;

import insurance.pojo.PersonalPolicy;
import insurance.repository.PersonalPoliceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalPolicyService {

    @Autowired
    PersonalPoliceRepo personalPoliceRepo;

    public PersonalPolicy createPolice(PersonalPolicy personalPolicy){
        return personalPoliceRepo.save(personalPolicy);
    }

    public Optional<PersonalPolicy> findPoliceById(Integer policeId) {
        return personalPoliceRepo.findById(policeId);
    }

    public List<PersonalPolicy> findAllPolices() {
        return (List<PersonalPolicy>) personalPoliceRepo.findAll();
    }

}
