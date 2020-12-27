package insurance.repository;
import insurance.model.PersonalPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonalPoliceRepo extends CrudRepository<PersonalPolicy, Long> {

    PersonalPolicy findById(long policeId);
    List<PersonalPolicy> findAll();

}
