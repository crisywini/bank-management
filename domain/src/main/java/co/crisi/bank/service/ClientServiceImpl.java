package co.crisi.bank.service;

import co.crisi.bank.data.ClientDto;
import co.crisi.bank.port.api.ClientServicePort;
import co.crisi.bank.port.spi.ClientPersistencePort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.client.ResourceAccessException;

@AllArgsConstructor
public class ClientServiceImpl implements ClientServicePort {

    private ClientPersistencePort clientPersistencePort;

    @Override
    public ClientDto save(ClientDto client) {
        return clientPersistencePort.save(client);
    }

    @Override
    public void delete(Long id) {
        clientPersistencePort.delete(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientPersistencePort.findAll();
    }

    @Override
    public ClientDto findById(Long id) {
        return clientPersistencePort.findById(id)
                .orElseThrow(() -> new ResourceAccessException(String.format("Client %d not found", id)));
    }

}
