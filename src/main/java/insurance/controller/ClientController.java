package insurance.controller;

import insurance.dto.InsuranceClientDTO;
import insurance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<InsuranceClientDTO> createClient(@RequestBody InsuranceClientDTO client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<InsuranceClientDTO> findClientById(@PathVariable Integer clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @GetMapping("/clients")
    public ResponseEntity<List<InsuranceClientDTO>> findAllClients() {

        return ResponseEntity.ok(clientService.findAllClients());
    }
}
