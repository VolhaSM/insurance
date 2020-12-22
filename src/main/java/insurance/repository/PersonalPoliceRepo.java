package insurance.repository;

import insurance.pojo.PersonalPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPoliceRepo extends CrudRepository <PersonalPolicy, Integer> {
}
