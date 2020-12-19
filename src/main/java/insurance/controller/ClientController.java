package insurance.controller;

import insurance.pojo.InsuranceClient;
import insurance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/clients")
    public InsuranceClient createClient(@RequestBody InsuranceClient client) {
        return clientService.createClient(client);
    }

    @GetMapping("/clients/{clientId}")
    public Optional<InsuranceClient> findClientById(@PathVariable Integer clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/clients")
    public List<InsuranceClient> findAllClients() {
        return clientService.findAllClients();
    }
}
