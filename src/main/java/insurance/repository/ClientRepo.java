package insurance.repository;
import insurance.model.InsuranceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<InsuranceClient, Integer> {

    InsuranceClient findById(int id);
    List<InsuranceClient> findAll();
}
