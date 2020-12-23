package insurance.service;

import insurance.dto.InsuranceClientDTO;
import insurance.mapper.InsuranceClientMapper;
import insurance.model.InsuranceClient;
import insurance.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    InsuranceClientMapper insuranceClientMapper;

    public InsuranceClientDTO createClient(InsuranceClientDTO client) {

        InsuranceClient savedClient = clientRepo.save(insuranceClientMapper.toInsuranceClient(client));
        return insuranceClientMapper.toInsuranceClientDTO(savedClient);
    }

    public InsuranceClientDTO getClientById(int clientId) {

        return insuranceClientMapper.toInsuranceClientDTO(clientRepo.findById(clientId));
    }

    public List<InsuranceClientDTO> findAllClients() {

        return clientRepo.findAll()
                .stream()
                .map(c -> insuranceClientMapper.toInsuranceClientDTO(c))
                .collect(Collectors.toList());
    }
}
