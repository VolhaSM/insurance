package insurance.repository;
import insurance.model.InsuranceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<InsuranceClient, Long> {

    InsuranceClient findById(long id);
    List<InsuranceClient> findAll();
}
