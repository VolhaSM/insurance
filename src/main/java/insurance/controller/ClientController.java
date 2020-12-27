package insurance.controller;
import insurance.dto.InsuranceClientDTO;
import insurance.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<InsuranceClientDTO> createClient(@RequestBody @Valid InsuranceClientDTO client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<InsuranceClientDTO> findClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @GetMapping("/clients")
    public ResponseEntity<List<InsuranceClientDTO>> findAllClients() {

        return ResponseEntity.ok(clientService.findAllClients());
    }
}
