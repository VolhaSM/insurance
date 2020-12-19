package insurance.service;

import insurance.pojo.PersonalPolice;
import insurance.repository.PersonalPoliceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalPoliceService {

    @Autowired
    PersonalPoliceRepo personalPoliceRepo;

    public PersonalPolice createPolice(PersonalPolice personalPolice){
        return personalPoliceRepo.save(personalPolice);
    }

    public Optional<PersonalPolice> findPoliceById(Integer policeId) {
        return personalPoliceRepo.findById(policeId);
    }

    public List<PersonalPolice> findAllPolices() {
        return (List<PersonalPolice>) personalPoliceRepo.findAll();
    }

}
