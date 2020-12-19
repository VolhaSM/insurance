package insurance.repository;

import insurance.pojo.InsuranceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<InsuranceClient, Integer> {


}
