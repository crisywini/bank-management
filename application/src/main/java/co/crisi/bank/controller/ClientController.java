package co.crisi.bank.controller;

import co.crisi.bank.data.ClientDto;
import co.crisi.bank.port.api.ClientServicePort;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServicePort clientServicePort;


    @PostMapping
    public ResponseEntity<Long> save(
            @RequestBody
                    ClientDto client) {
        val clientSaved = clientServicePort.save(client);
        return new ResponseEntity(clientSaved.id(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(
            @PathVariable(name = "clientId")
                    Long clientId) {
        clientServicePort.delete(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientServicePort.findAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> findById(
            @PathVariable(name = "clientId")
                    Long clientId) {
        val clientDto = clientServicePort.findById(clientId);
        return ResponseEntity.ok(clientDto);
    }


}
