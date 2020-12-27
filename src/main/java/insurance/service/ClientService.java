package insurance.service;
import insurance.dto.InsuranceClientDTO;
import insurance.mapper.InsuranceClientMapper;
import insurance.model.InsuranceClient;
import insurance.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final InsuranceClientMapper insuranceClientMapper;

    public InsuranceClientDTO createClient(InsuranceClientDTO client) {

        InsuranceClient savedClient = clientRepo.save(insuranceClientMapper.toInsuranceClient(client));
        return insuranceClientMapper.toInsuranceClientDTO(savedClient);
    }

    public InsuranceClientDTO getClientById(long clientId) {

        return insuranceClientMapper.toInsuranceClientDTO(clientRepo.findById(clientId));
    }

    public List<InsuranceClientDTO> findAllClients() {

        return clientRepo.findAll()
                .stream()
                .map(c -> insuranceClientMapper.toInsuranceClientDTO(c))
                .collect(Collectors.toList());
    }
}
