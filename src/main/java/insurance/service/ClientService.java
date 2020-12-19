package insurance.service;

import insurance.pojo.InsuranceClient;
import insurance.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    public InsuranceClient createClient(InsuranceClient client) {

        if(client.getPolice().isEmpty()) {
            client.setPolice(null);
        }
        return clientRepo.save(client);
    }

    public Optional getClientById(Integer clientId) {
        return clientRepo.findById(clientId);
    }

    public List<InsuranceClient> findAllClients() {
        return (List<InsuranceClient>) clientRepo.findAll();
    }
}
