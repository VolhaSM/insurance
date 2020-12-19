package insurance.repository;

import insurance.pojo.PersonalPolice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPoliceRepo extends CrudRepository <PersonalPolice, Integer> {
}
