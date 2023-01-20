package co.crisi.bank.adapter;

import co.crisi.bank.data.ClientDto;
import co.crisi.bank.entity.Client;
import co.crisi.bank.exception.ResourceNotFoundException;
import co.crisi.bank.mapper.ClientMapper;
import co.crisi.bank.port.spi.ClientPersistencePort;
import co.crisi.bank.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientJpaAdapter implements ClientPersistencePort {


    @Autowired
    private ClientRepository clientRepository;

    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    @Override
    public ClientDto save(ClientDto client) {
        val clientEntity = clientMapper.mapToEntity(client);
        return clientMapper.mapToDto(clientRepository.save(clientEntity));
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        val client = clientRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                String.format("Could not found a client with id %d", id)));

        return Optional.of(clientMapper.mapToDto(client));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.mapToDtos(clientRepository.findAll());
    }

}
